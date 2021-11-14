package mws.measurement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("measurements")
class Measurement {
	@Id
	private String _id;

	private String stationId;
	private String measurementDate;
	private long measurementId;
	private float temperature;
	private float humidity;

	public Measurement() {
	}

	public Measurement(String stationId, String measurementDate, long measurementId, float temperature,
			float humidity) {
		this.stationId = stationId;
		this.measurementDate = measurementDate;
		this.measurementId = measurementId;
		this.temperature = temperature;
		this.humidity = humidity;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getMeasurementDate() {
		return measurementDate;
	}

	public void setMeasurementDate(String measurementDate) {
		this.measurementDate = measurementDate;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public long getMeasurementId() {
		return measurementId;
	}

	public void setMeasurementId(long measurementId) {
		this.measurementId = measurementId;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public MeasurementDTO translateToDto() {
		MeasurementDTO dto = new MeasurementDTO(getStationId(), getMeasurementDate(), getMeasurementId(),
				getTemperature(), getHumidity());
		return dto;
	}

}
