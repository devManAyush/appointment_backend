package Project.appointment_backend.controller;

import Project.appointment_backend.dto.CreateDoctorDto;
import Project.appointment_backend.dto.CreatePatientDto;
import Project.appointment_backend.dto.DoctorDto;
import Project.appointment_backend.dto.PatientDto;
import Project.appointment_backend.service.DoctorService;
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
@RequestMapping("api/v1/doctor")

public class DoctorController {
    private final DoctorService doctorService;
    @PostMapping
    public ResponseEntity<DoctorDto> addDoctor(@RequestBody CreateDoctorDto createDoctorDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.addDoctor(createDoctorDto));
    }
}
