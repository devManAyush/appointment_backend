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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/doctor")

public class DoctorController {
    private final DoctorService doctorService;
    @PostMapping
    public ResponseEntity<DoctorDto> addDoctor(@RequestBody CreateDoctorDto createDoctorDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.addDoctor(createDoctorDto));
    }
    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllPatients() {
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.getAllPatients());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.getDoctorById(id));
    }
    @DeleteMapping("doctor/{id}")
    public ResponseEntity <Void> deleteUserById(@PathVariable int id){
        doctorService.deleteDoctorById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<DoctorDto> patchDoctor(@PathVariable int id, @RequestBody CreateDoctorDto patchDoctorDto) {
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.patchDoctor(id,patchDoctorDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable int id, @RequestBody CreateDoctorDto updateDoctorDto) {
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.updateDoctor(id,updateDoctorDto));
    }
}
