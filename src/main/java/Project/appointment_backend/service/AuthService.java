package Project.appointment_backend.service;

import Project.appointment_backend.dto.CreatePatientDto;
import Project.appointment_backend.dto.RegisterPatientDto;
import Project.appointment_backend.entities.Patient;
import Project.appointment_backend.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final PatientRepository patientRepository;
    public void signUpUser(CreatePatientDto createPatientDto){
        Patient patient = new Patient();
        patient.setName(createPatientDto.getName());
        patient.setMail(createPatientDto.getMail());
        patient.setPassword(passwordEncoder.encode(createPatientDto.getPassword()));
        patient.setPhone(createPatientDto.getPhone());
        patientRepository.save(patient);
    }
}
