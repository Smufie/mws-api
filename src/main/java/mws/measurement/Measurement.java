package mws.measurement;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("measurements")
class Measurement {
	@Id
	private String _id;

	private String stationId;
	private LocalDateTime measurementDate;
	private long measurementId;
	private float temperature;
	private float humidity;
	private int airQuality;
	private float pressure;

	public Measurement() {
	}

	public Measurement(String stationId, LocalDateTime measurementDate, long measurementId, float temperature,
			float humidity, int airQuality, float pressure) {
		this.stationId = stationId;
		this.measurementDate = measurementDate;
		this.measurementId = measurementId;
		this.temperature = temperature;
		this.humidity = humidity;
		this.airQuality = airQuality;
		this.pressure = pressure;
	}

	public int getAirQuality() {
		return airQuality;
	}

	public void setAirQuality(int airQuality) {
		this.airQuality = airQuality;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public LocalDateTime getMeasurementDate() {
		return measurementDate;
	}

	public void setMeasurementDate(LocalDateTime measurementDate) {
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
				getTemperature(), getHumidity(), getAirQuality(), getPressure());
		return dto;
	}

}
