package mws.measurement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeasurementController {
	@Autowired
	private MeasurementService service;

	@PostMapping("/measurements")
	public ResponseEntity<MeasurementDTO> saveMeasurment(@RequestBody MeasurementDTO newMeteoData) {
		return ResponseEntity.ok(service.saveMeasurment(newMeteoData));
	}

	@GetMapping("/measurements/{id}")
	public ResponseEntity<MeasurementDTO> getMeasurmentById(@PathVariable float id) {
		return ResponseEntity.ok(service.getMeasurmentById(id));
	}

	@CrossOrigin(origins = { "https://mwsuserportal.herokuapp.com", "http://localhost:3000" })
	@GetMapping("/measurements")
	public ResponseEntity<List<MeasurementDTO>> getAllMeasurments() {
		return ResponseEntity.ok(service.getAllMeasurments());
	}

	@CrossOrigin(origins = { "https://mwsuserportal.herokuapp.com", "http://localhost:3000" })
	@GetMapping("/measurements/{from}/{to}")
	public ResponseEntity<List<MeasurementDTO>> getMeasurmentsByDate(@PathVariable String from, @PathVariable String to)
			throws Exception {
		return ResponseEntity.ok(service.getAllMeasurmentsByDate(from, to));
	}
}
