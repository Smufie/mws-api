package mws.measurement;
public class MeasurementDTO {
	private long measurementId;
	private float temperature;
	private float humidity;
	private float pressure;
	private float airQualityIndex;

	public MeasurementDTO() {

	}

	public MeasurementDTO(long readingId, float temperature, float humidity, float pressure, float airQualityIndex) {
		super();
		this.measurementId = readingId;
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		this.airQualityIndex = airQualityIndex;
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

}