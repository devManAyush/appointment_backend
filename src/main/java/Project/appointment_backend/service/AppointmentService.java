package Project.appointment_backend.service;

import Project.appointment_backend.dto.AppointmentDto;
import Project.appointment_backend.dto.CreateAppointmentDto;
import Project.appointment_backend.entities.Appointment;
import Project.appointment_backend.entities.Doctor;
import Project.appointment_backend.entities.Patient;
import Project.appointment_backend.repository.AppointmentRepository;
import Project.appointment_backend.repository.DoctorRepository;
import Project.appointment_backend.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public AppointmentDto bookAppointment(CreateAppointmentDto dto) {

        Doctor availableDoctor = doctorRepository.findFirstAvailableDoctorBySpecialty(dto.getSpecialty())
                .orElseThrow(() -> new RuntimeException("No available doctor found for specialty: " + dto.getSpecialty()));

        Patient newPatient = new Patient();
        newPatient.setName(dto.getPatientName());
        newPatient.setEmail(dto.getPatientEmail());
        newPatient.setPhone(dto.getPatientPhone());
        Patient savedPatient = patientRepository.save(newPatient);

        Appointment appointment = new Appointment();
        appointment.setAppointment_dateTime(LocalDateTime.parse(dto.getAppointmentDate()));
        appointment.setStatus("SCHEDULED");
        appointment.setPatient(savedPatient);
        appointment.setDoctor(availableDoctor);

        Appointment savedAppointment = appointmentRepository.save(appointment);

        availableDoctor.setAvailability("NOT_AVAILABLE");
        doctorRepository.save(availableDoctor);

        return new AppointmentDto(
                savedAppointment.getId(),
                savedAppointment.getAppointment_dateTime(),
                savedAppointment.getStatus(),
                savedPatient.getId(),
                savedPatient.getName(),
                availableDoctor.getId(),
                availableDoctor.getName()
        );
    }
}