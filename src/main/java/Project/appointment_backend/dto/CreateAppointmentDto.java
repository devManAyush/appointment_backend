package Project.appointment_backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class CreateAppointmentDto {
    private int patientId;
    private int doctorId;
    private LocalDateTime appointmentDate;
    private String status;
}
