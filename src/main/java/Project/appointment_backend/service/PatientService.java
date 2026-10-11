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

    public PatientDto addPatient(CreatePatientDto createPatientDto) {
        Patient patient = new Patient();
        patient.setName(createPatientDto.getName());
        patient.setEmail(createPatientDto.getEmail());
        patient.setPhone(createPatientDto.getPhone());
        Patient addedPatient=patientRepository.save(patient);
        return new PatientDto(addedPatient.getId(), addedPatient.getName(),addedPatient.getEmail(),addedPatient.getPhone());
    }

    public List<PatientDto> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientDto> patientDtoList = new ArrayList<>();
        for(Patient patient:patients){
            PatientDto patientDto=new PatientDto(patient.getId(), patient.getEmail(), patient.getName(), patient.getPhone());
            patientDtoList.add(patientDto);
        }
        return patientDtoList;
    }

    public PatientDto getPatientById(int id) {
        Patient patient = patientRepository.findById(id).orElseThrow();
        return new PatientDto(patient.getId(), patient.getEmail(), patient.getName(), patient.getPhone());
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
        if(patchPatientDto.getEmail()!=null){
            patient.setEmail(patchPatientDto.getEmail());
        }
        if(patchPatientDto.getPhone()!=null){
            patient.setPhone(patchPatientDto.getPhone());
        }
        return new PatientDto(patient.getId(), patient.getEmail(), patient.getName(), patient.getPhone());
    }

    public PatientDto updatePatient(int id, CreatePatientDto updatePatientDto) {
        Patient patient = patientRepository.findById(id).orElseThrow();
        patient .setName(updatePatientDto.getName());
        patient.setEmail(updatePatientDto.getEmail());
        patient.setPhone(updatePatientDto.getPhone());
        return new PatientDto(patient.getId(), patient.getEmail(), patient.getName(), patient.getPhone());
    }
}
