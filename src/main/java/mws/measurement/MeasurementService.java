package mws.measurement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
class MeasurementService {

	@Autowired
	MeasurementRepository repository;

	private final MongoTemplate template;

	public MeasurementService(MongoTemplate template) {
		super();
		this.template = template;
	}

	public MeasurementDTO saveMeasurment(MeasurementDTO newMeteoData) {
		String datePattern = "yyyy-MM-dd HH:mm:ss";
		DateFormat format = new SimpleDateFormat(datePattern);
		Date date = Calendar.getInstance().getTime();
		String measurementDate = format.format(date);

		Measurement meteoData = new Measurement(newMeteoData.getStationId(), measurementDate,
				newMeteoData.getMeasurementId(), newMeteoData.getHumidity(), newMeteoData.getTemperature());
		repository.save(meteoData);
		newMeteoData.setMeasurementDate(measurementDate);
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
		List<Measurement> personEntities = repository.findAll();
		List<MeasurementDTO> personsDto = new ArrayList<MeasurementDTO>();
		personEntities.forEach((entity) -> {
			personsDto.add(entity.translateToDto());
		});
		return personsDto;
	}

	public List<MeasurementDTO> getAllMeasurmentsByDate() {
		// TODO Auto-generated method stub
		return null;
	}
}
