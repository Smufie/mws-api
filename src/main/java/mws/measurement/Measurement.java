package mws.measurement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("measurements")
class Measurement {
	@Id
	private String _id;
	private long measurementId;

	private float humidity;
	private float temperature;
	private float pressure;
	private float airQualityIndex;

	public Measurement() {
	}

	public Measurement(long measurementId, float humidity, float temperature, float pressure, float airQualityIndex) {
		this.measurementId = measurementId;
		this.humidity = humidity;
		this.temperature = temperature;
		this.pressure = pressure;
		this.airQualityIndex = airQualityIndex;
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

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public float getAirQualityIndex() {
		return airQualityIndex;
	}

	public void setAirQualityIndex(float airQualityIndex) {
		this.airQualityIndex = airQualityIndex;
	}

	public MeasurementDTO translateToDto() {
		MeasurementDTO dto = new MeasurementDTO(getMeasurementId(), getTemperature(), getHumidity(), getPressure(), getAirQualityIndex());
		return dto;
	}

}