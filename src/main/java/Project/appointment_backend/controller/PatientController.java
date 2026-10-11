package Project.appointment_backend.controller;

import Project.appointment_backend.dto.CreatePatientDto;
import Project.appointment_backend.dto.PatientDto;
import Project.appointment_backend.entities.Patient;
import Project.appointment_backend.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/patient")

public class PatientController {
    private final PatientService patientService;
    @PostMapping
    public ResponseEntity<PatientDto> addPatient(@RequestBody CreatePatientDto createPatientDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.addPatient(createPatientDto));
    }
}
