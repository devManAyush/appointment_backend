package Project.appointment_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class AppointmentDto {
    private int appointmentId;
    private LocalDateTime appointmentDate;
    private String status;
    private int patientId;
    private String patientName;
    private int doctorId;
    private String doctorName;
}
