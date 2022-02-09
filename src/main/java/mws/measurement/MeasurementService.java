package mws.measurement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.mongodb.client.MongoClients;

@Service
class MeasurementService {
	@Autowired
	MeasurementRepository repository;
	private final MongoTemplate template;
	private final static String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
	private final static DateFormat FORMAT = new SimpleDateFormat(DATE_PATTERN);

	public MeasurementService(MongoTemplate template) {
		super();
		this.template = template;
	}

	public MeasurementDTO saveMeasurment(MeasurementDTO newMeteoData) {
		LocalDateTime currentDate = LocalDateTime.now();

		Measurement meteoData = new Measurement(newMeteoData.getStationId(), currentDate,
				newMeteoData.getMeasurementId(), newMeteoData.getTemperature(), newMeteoData.getHumidity(),
				newMeteoData.getAirQuality(), newMeteoData.getPressure());
		repository.save(meteoData);
		newMeteoData.setMeasurementDate(currentDate);
		return newMeteoData;
	}
	public MeasurementDTO getMeasurmentById(float id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("measurementId").is(id));
		List<Measurement> measurement = template.find(query, Measurement.class);
		MeasurementDTO measurementDTO = measurement.get(0).translateToDto();
		return measurementDTO;
	}
	public List<MeasurementDTO> getAllMeasurments() {
		List<Measurement> measurementsEntities = repository.findAll();
		List<MeasurementDTO> measurementsDto = new ArrayList<MeasurementDTO>();
		measurementsEntities.forEach((entity) -> {
			measurementsDto.add(entity.translateToDto());
		});
		return measurementsDto;
	}

	public List<MeasurementDTO> getAllMeasurmentsByDate(String from, String to) throws ParseException {
		Date fromDate = FORMAT.parse(from);
		Date toDate = FORMAT.parse(to);

		Query query = buildQuery(fromDate, toDate);

		MongoOperations mongoOps = new MongoTemplate(
				MongoClients.create("mongodb+srv://admin:admin@cluster0.cg9hx.mongodb.net/test"), "mws-data");
		List<MeasurementDTO> result = mongoOps.find(query, MeasurementDTO.class, "measurements");

		return result;
	}

	private Query buildQuery(Date fromDate, Date toDate) {
		Criteria fromCriteria = Criteria.where("measurementDate").gte(fromDate);
		Criteria toCriteria = Criteria.where("measurementDate").lte(toDate);
		Criteria mainCriteria = new Criteria().andOperator(fromCriteria, toCriteria);

		return Query.query(mainCriteria);
	}
}