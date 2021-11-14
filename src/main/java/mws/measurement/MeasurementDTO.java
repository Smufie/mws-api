package mws.measurement;

public class MeasurementDTO {

	private String stationId;
	private String measurementDate;
	private long measurementId;
	private float temperature;
	private float humidity;

	public MeasurementDTO() {

	}

	public MeasurementDTO(String stationId, String measurementDate, long measurementId, float temperature,
			float humidity) {
		super();
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
