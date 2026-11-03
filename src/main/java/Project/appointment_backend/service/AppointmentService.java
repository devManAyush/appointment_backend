package Project.appointment_backend.service;

import Project.appointment_backend.dto.AppointmentDto;
import Project.appointment_backend.dto.CreateAppointmentDto;
import Project.appointment_backend.dto.CreateSlotDto;
import Project.appointment_backend.entities.*;
import Project.appointment_backend.repository.AppointmentRepository;
import Project.appointment_backend.repository.DoctorRepository;
import Project.appointment_backend.repository.PatientRepository;
import Project.appointment_backend.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private SlotRepository slotRepository;

    @Transactional
    public AppointmentDto bookAppointment(CreateAppointmentDto createAppointmentDto) {
        Doctor doctor = doctorRepository.findById(createAppointmentDto.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Patient patient = patientRepository.findById(createAppointmentDto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Slot slot = slotRepository.findById(createAppointmentDto.getSlotId())
                .orElseThrow(() -> new RuntimeException("Slot not found"));

        if (slot.getStatus() == SlotStatus.BOOKED) {
            throw new RuntimeException("Slot is already booked!");
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