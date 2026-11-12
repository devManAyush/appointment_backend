package Project.appointment_backend.controller;

import Project.appointment_backend.dto.CreatePatientDto;
import Project.appointment_backend.dto.PatientDto;

import Project.appointment_backend.service.PatientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/patient")

public class PatientController {
    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatients() {
        return ResponseEntity.status(HttpStatus.OK).body(patientService.getAllPatients());
    }
    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(patientService.getPatientById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteUserById(@PathVariable int id){
            patientService.deleteUserById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<PatientDto> patchPatient(@PathVariable int id, @Valid @RequestBody CreatePatientDto patchPatientDto) {
        return ResponseEntity.status(HttpStatus.OK).body(patientService.patchPatient(id,patchPatientDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable int id, @Valid @RequestBody CreatePatientDto updatePatientDto) {
        return ResponseEntity.status(HttpStatus.OK).body(patientService.updatePatient(id,updatePatientDto));
    }
}
