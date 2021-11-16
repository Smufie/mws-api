package mws.measurement;

public class MeasurementDTO {
	private long measurementId;
	private float temperature;
	private float humidity;

	public MeasurementDTO() {

	}

	public MeasurementDTO(long readingId, float temperature, float humidity) {
		super();
		this.measurementId = readingId;
		this.temperature = temperature;
		this.humidity = humidity;
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
