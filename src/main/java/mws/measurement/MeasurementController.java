package mws.measurement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeasurementController {
	@Autowired
	private MeasurementService service;

	@PostMapping("/measurement/save")
	public ResponseEntity<MeasurementDTO> saveMeasurment(@RequestBody MeasurementDTO newMeteoData) {
		return ResponseEntity.ok(service.saveMeasurment(newMeteoData));
	}

	@GetMapping("/measurement/get/{id}")
	public ResponseEntity<MeasurementDTO> getMeasurmentById(@PathVariable float id) {
		return ResponseEntity.ok(service.getMeasurmentById(id));
	}

	@GetMapping("/measurement/get")
	public ResponseEntity<List<MeasurementDTO>> getAllMeasurments() {
		return ResponseEntity.ok(service.getAllMeasurments());
	}
}
