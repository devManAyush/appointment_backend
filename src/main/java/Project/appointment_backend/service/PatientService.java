package Project.appointment_backend.service;

import Project.appointment_backend.dto.CreatePatientDto;
import Project.appointment_backend.dto.PatientDto;
import Project.appointment_backend.entities.Patient;
import Project.appointment_backend.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class PatientService {
    private final PatientRepository patientRepository;
    public PatientDto addPatient(CreatePatientDto createPatientDto) {
        Patient patient = new Patient();
        patient.setName(createPatientDto.getName());
        patient.setEmail(createPatientDto.getEmail());
        patient.setPhone(createPatientDto.getPhone());
        Patient addedPatient=patientRepository.save(patient);
        return new PatientDto(addedPatient.getId(), addedPatient.getName(),addedPatient.getEmail(),addedPatient.getPhone());
    }
}
