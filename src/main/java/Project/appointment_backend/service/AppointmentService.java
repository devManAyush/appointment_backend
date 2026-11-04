package Project.appointment_backend.service;

import Project.appointment_backend.dto.AppointmentDto;
import Project.appointment_backend.dto.CreateAppointmentDto;
import Project.appointment_backend.dto.CreateSlotDto;
import Project.appointment_backend.entities.*;
import Project.appointment_backend.exception.CustomApiException;
import Project.appointment_backend.exception.ErrorCode;
import Project.appointment_backend.repository.AppointmentRepository;
import Project.appointment_backend.repository.DoctorRepository;
import Project.appointment_backend.repository.PatientRepository;
import Project.appointment_backend.repository.SlotRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;


@RequiredArgsConstructor
@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final SlotRepository slotRepository;

    @Transactional
    public AppointmentDto bookAppointment(CreateAppointmentDto createAppointmentDto) {
        Doctor doctor = doctorRepository.findById(createAppointmentDto.getDoctorId())
                .orElseThrow(() -> new CustomApiException(ErrorCode.RESOURCE_NOT_FOUND, "Doctor not found with ID: " + createAppointmentDto.getDoctorId()));

        Patient patient = patientRepository.findById(createAppointmentDto.getPatientId())
                .orElseThrow(() -> new CustomApiException(ErrorCode.RESOURCE_NOT_FOUND, "Patient not found with ID: " + createAppointmentDto.getPatientId()));

        Slot slot = slotRepository.findById(createAppointmentDto.getSlotId())
                .orElseThrow(() -> new CustomApiException(ErrorCode.RESOURCE_NOT_FOUND, "Slot not found with ID: " + createAppointmentDto.getSlotId()));

        if (slot.getStatus() == SlotStatus.BOOKED) {
            throw new CustomApiException(ErrorCode.SLOT_ALREADY_BOOKED, "Slot with ID " + createAppointmentDto.getSlotId() + " is already booked.");
        }

        slot.setStatus(SlotStatus.BOOKED);
        slotRepository.save(slot);

        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setSlot(slot);

        Appointment savedAppointment = appointmentRepository.save(appointment);

        return toAppointmentDto(savedAppointment);
    }

    private AppointmentDto toAppointmentDto(Appointment appointment) {
        CreateSlotDto slotDto = new CreateSlotDto();
        slotDto.setStartTime(appointment.getSlot().getStartTime());
        slotDto.setEndTime(appointment.getSlot().getEndTime());

        return new AppointmentDto(
                appointment.getId(),
                appointment.getDoctor().getName(),
                appointment.getPatient().getName(),
                slotDto
        );
    }
}