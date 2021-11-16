package mws.measurement;

import java.util.ArrayList;
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
		Measurement meteoData = new Measurement(newMeteoData.getMeasurementId(), newMeteoData.getHumidity(),
				newMeteoData.getTemperature(), newMeteoData.getPressure(), newMeteoData.getAirQualityIndex());
		repository.save(meteoData);

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
}
