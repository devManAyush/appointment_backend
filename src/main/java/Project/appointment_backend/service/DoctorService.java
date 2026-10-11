package Project.appointment_backend.service;

import Project.appointment_backend.dto.CreateDoctorDto;
import Project.appointment_backend.dto.DoctorDto;
import Project.appointment_backend.dto.PatientDto;
import Project.appointment_backend.entities.Doctor;
import Project.appointment_backend.entities.Patient;
import Project.appointment_backend.repository.DoctorRepository;
import Project.appointment_backend.repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@AllArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    public DoctorDto addDoctor(CreateDoctorDto createDoctorDto) {
        Doctor doctor = new Doctor();
        doctor.setName(createDoctorDto.getName());
        doctor.setSpecialty(createDoctorDto.getSpeciality());
        if (createDoctorDto.getAvailability() != null && !createDoctorDto.getAvailability().isBlank()) {
            doctor.setAvailability(createDoctorDto.getAvailability());
        } else {
            doctor.setAvailability("AVAILABLE");
        }
        doctor.setSalary(createDoctorDto.getSalary());
        Doctor addedDoctor=doctorRepository.save(doctor);
        return new DoctorDto(addedDoctor.getId(), addedDoctor.getName(),addedDoctor.getSpecialty(),addedDoctor.getAvailability(),addedDoctor.getSalary());
    }
}
