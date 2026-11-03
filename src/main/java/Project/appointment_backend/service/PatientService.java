package Project.appointment_backend.service;

import Project.appointment_backend.dto.CreatePatientDto;
import Project.appointment_backend.dto.PatientDto;
import Project.appointment_backend.entities.Patient;
import Project.appointment_backend.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class PatientService {
    private final PatientRepository patientRepository;

    public List<PatientDto> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientDto> patientDtoList = new ArrayList<>();
        for(Patient patient:patients){
            patientDtoList.add(toPatientDto(patient));
        }
        return patientDtoList;
    }

    public PatientDto getPatientById(int id) {
        Patient patient = patientRepository.findById(id).orElseThrow();
        return  toPatientDto(patient);
    }

    public void deleteUserById(int id) {
        patientRepository.deleteById(id);
    }

    @Transactional
    public PatientDto patchPatient(int id, CreatePatientDto patchPatientDto) {
        Patient patient = patientRepository.findById(id).orElseThrow();
        if(patchPatientDto.getName()!=null){
            patient.setName(patchPatientDto.getName());
        }
        if(patchPatientDto.getMail()!=null){
            patient.setMail(patchPatientDto.getMail());
        }
        if(patchPatientDto.getPhone()!=null){
            patient.setPhone(patchPatientDto.getPhone());
        }
        if(patchPatientDto.getAge()!=null) {
            patient.setAge(patchPatientDto.getAge());
        }
        if(patchPatientDto.getGender()!=null) {
            patient.setGender(patchPatientDto.getGender());
        }
        if(patchPatientDto.getDisease()!=null) {
            patient.setDisease(patchPatientDto.getDisease());
        }
        return toPatientDto(patient);
    }

    @Transactional
    public PatientDto updatePatient(int id, CreatePatientDto updatePatientDto) {
        Patient patient = patientRepository.findById(id).orElseThrow();
        patient .setName(updatePatientDto.getName());
        patient.setMail(updatePatientDto.getMail());
        patient.setPhone(updatePatientDto.getPhone());
        patient.setAge(updatePatientDto.getAge());
        patient.setGender(updatePatientDto.getGender());
        patient.setDisease(updatePatientDto.getDisease());
        return toPatientDto(patient);
    }

    public PatientDto addPatient(CreatePatientDto createPatientDto) {
        Patient patient = new Patient();
        patient.setName(createPatientDto.getName());
        patient.setMail(createPatientDto.getMail());
        patient.setPhone(createPatientDto.getPhone());
        patient.setAge(createPatientDto.getAge());
        patient.setGender(createPatientDto.getGender());
        patient.setDisease(createPatientDto.getDisease());
        Patient savedPatient = patientRepository.save(patient);
        return toPatientDto(savedPatient);
    }

    private PatientDto toPatientDto(Patient patient) {
        return new PatientDto(
                patient.getId(),
                patient.getName(),
                patient.getMail(),
                patient.getPhone(),
                patient.getAge(),
                patient.getGender(),
                patient.getDisease()
        );
    }
}
