package Project.appointment_backend.service;

import Project.appointment_backend.dto.CreateDoctorDto;
import Project.appointment_backend.dto.CreateSlotDto;
import Project.appointment_backend.dto.DoctorDto;
import Project.appointment_backend.entities.*;
import Project.appointment_backend.exception.CustomApiException;
import Project.appointment_backend.exception.ErrorCode;
import Project.appointment_backend.repository.AccountRepository;
import Project.appointment_backend.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
@AllArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public DoctorDto addDoctor(CreateDoctorDto createDoctorDto) {
        if (createDoctorDto.getInitialPassword() == null
                || createDoctorDto.getInitialPassword().isBlank()) {
            throw new CustomApiException(
                    ErrorCode.INVALID_INPUT,
                    "An initial password is required when creating a doctor."
            );
        }
        if (accountRepository.existsByEmail(createDoctorDto.getMail())) {
            throw new CustomApiException(
                    ErrorCode.INVALID_INPUT,
                    "An account with this email already exists."
            );
        }
        Account account = new Account();
        account.setName(createDoctorDto.getName());
        account.setEmail(createDoctorDto.getMail());
        account.setPassword(passwordEncoder.encode(createDoctorDto.getInitialPassword()));
        account.setRole(Role.DOCTOR);
        accountRepository.save(account);

        Doctor doctor = new Doctor();
        doctor.setAccount(account);
        doctor.setName(createDoctorDto.getName());
        doctor.setMail(createDoctorDto.getMail());
        doctor.setPhone(createDoctorDto.getPhone());
        doctor.setSpecialty(createDoctorDto.getSpecialty());
        doctor.setVisitingFees(createDoctorDto.getVisitingFees());
        doctor.setSalary(createDoctorDto.getSalary());
        List<Slot> slots = new ArrayList<>();
        if (createDoctorDto.getSlots() != null) {
            for (CreateSlotDto slotDto : createDoctorDto.getSlots()) {
                Slot slot = new Slot();
                slot.setStartTime(slotDto.getStartTime());
                slot.setEndTime(slotDto.getEndTime());
                slot.setStatus(SlotStatus.AVAILABLE);
                slot.setDoctor(doctor);
                slots.add(slot);
            }
        }
        doctor.setSlots(slots);
        Doctor addedDoctor=doctorRepository.save(doctor);
        return toDoctorDto(addedDoctor);
    }


    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        List<DoctorDto> doctorDtos = new ArrayList<>();
        for (Doctor doctor : doctors) {
            doctorDtos.add(toDoctorDto(doctor));
        }
        return doctorDtos;
    }


    public DoctorDto getDoctorById(int id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(
                ()->new CustomApiException(ErrorCode.RESOURCE_NOT_FOUND, "Doctor not found with ID: " + id));
        return toDoctorDto(doctor);
    }


    public void deleteDoctorById(int id) {
        doctorRepository.deleteById(id);
    }


    @Transactional
    public DoctorDto patchDoctor(int id, CreateDoctorDto patchDoctorDto) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(
                ()->new CustomApiException(ErrorCode.RESOURCE_NOT_FOUND, "Doctor not found with ID: " + id)
        );
        if (patchDoctorDto.getSlots() != null) {
            List<Slot> slots = new ArrayList<>();
            for (CreateSlotDto slotDto : patchDoctorDto.getSlots()) {
                Slot slot = new Slot();
                slot.setStartTime(slotDto.getStartTime());
                slot.setEndTime(slotDto.getEndTime());
                slot.setStatus(SlotStatus.AVAILABLE);
                slot.setDoctor(doctor);
                slots.add(slot);
            }
            doctor.setSlots(slots);
        }
        return toDoctorDto(doctor);
    }


    @Transactional
    public DoctorDto updateDoctor(int id, CreateDoctorDto updateDoctorDto) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(
                ()->new CustomApiException(ErrorCode.RESOURCE_NOT_FOUND, "Doctor not found with ID: " + id)
        );
        doctor.setName(updateDoctorDto.getName());
        doctor.setMail(updateDoctorDto.getMail());
        doctor.setPhone(updateDoctorDto.getPhone());
        doctor.setSpecialty(updateDoctorDto.getSpecialty());
        doctor.setVisitingFees(updateDoctorDto.getVisitingFees());
        doctor.setSalary(updateDoctorDto.getSalary());
        List<Slot> slots = new ArrayList<>();
        if (updateDoctorDto.getSlots() != null) {
            for (CreateSlotDto slotDto : updateDoctorDto.getSlots()) {
                Slot slot = new Slot();
                slot.setStartTime(slotDto.getStartTime());
                slot.setEndTime(slotDto.getEndTime());
                slot.setStatus(SlotStatus.AVAILABLE);
                slot.setDoctor(doctor);
                slots.add(slot);
            }
            doctor.setSlots(slots);
        }
        return toDoctorDto(doctor);
    }


    private DoctorDto toDoctorDto(Doctor doctor) {
        List<CreateSlotDto> slotDtos = new ArrayList<>();

        if (doctor.getSlots() != null) {
            for (Slot slot : doctor.getSlots()) {
                CreateSlotDto slotDto = new CreateSlotDto();
                slotDto.setStartTime(slot.getStartTime());
                slotDto.setEndTime(slot.getEndTime());
                slotDto.setStatus(slot.getStatus());
                slotDtos.add(slotDto);
            }
        }
        return new DoctorDto(
                doctor.getId(),
                doctor.getName(),
                doctor.getMail(),
                doctor.getPhone(),
                doctor.getSpecialty(),
                doctor.getVisitingFees(),
                doctor.getSalary(),
                slotDtos
        );
    }

}

