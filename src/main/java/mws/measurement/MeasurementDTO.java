package mws.measurement;

import java.time.LocalDateTime;

public class MeasurementDTO {

	private String stationId;
	private LocalDateTime measurementDate;
	private long measurementId;
	private float temperature;
	private float humidity;
	private int airQuality;
	private float pressure;

	public MeasurementDTO() {

	}

	public MeasurementDTO(String stationId, LocalDateTime measurementDate, long measurementId, float temperature,
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

	public long getMeasurementId() {
		return measurementId;
	}

	public void setMeasurementId(long measurementId) {
		this.measurementId = measurementId;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

}
