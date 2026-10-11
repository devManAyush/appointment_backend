package Project.appointment_backend.service;

import Project.appointment_backend.dto.CreateDoctorDto;
import Project.appointment_backend.dto.DoctorDto;
import Project.appointment_backend.entities.Doctor;
import Project.appointment_backend.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<DoctorDto> getAllPatients() {
        List<Doctor> doctors = doctorRepository.findAll();
        List<DoctorDto> DoctorDtoList = new ArrayList<>();
        for(Doctor doctor:doctors){
            DoctorDto DoctorDto=new DoctorDto(doctor.getId(), doctor.getSpecialty(), doctor
                    .getName(), doctor.getAvailability(), doctor.getSalary());
            DoctorDtoList.add(DoctorDto);
        }
        return DoctorDtoList;
    }

    public DoctorDto getDoctorById(int id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        return new DoctorDto(doctor.getId(), doctor.getAvailability(), doctor.getName(), doctor.getSpecialty(), doctor.getSalary());
    }

    public void deleteDoctorById(int id) {
        doctorRepository.deleteById(id);
    }

    @Transactional
    public DoctorDto patchDoctor(int id, CreateDoctorDto patchDoctorDto) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        if(patchDoctorDto.getName()!=null){
            doctor.setName(patchDoctorDto.getName());
        }
        if(patchDoctorDto.getAvailability()!=null){
            doctor.setAvailability(patchDoctorDto.getAvailability());
        }
        if(patchDoctorDto.getSpeciality()!=null){
            doctor.setSpecialty(patchDoctorDto.getSpeciality());
        }
        return new DoctorDto(doctor.getId(), doctor.getName(), doctor.getAvailability(), doctor.getSpecialty(), doctor.getSalary());
    }

    @Transactional
    public DoctorDto updateDoctor(int id, CreateDoctorDto updateDoctorDto) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        doctor .setName(updateDoctorDto.getName());
        doctor.setSpecialty(updateDoctorDto.getSpeciality());
        doctor.setSalary(updateDoctorDto.getSalary());
        return new DoctorDto(doctor.getId(), doctor.getName(),doctor.getSpecialty(), doctor.getAvailability(), doctor.getSalary());
    }
}

