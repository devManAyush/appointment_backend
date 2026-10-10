package Project.appointment_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class AppointmentDto {
    private int id;
    private String patient_id;
    private String patient_name;
    private String doctor_id;
    private String doctor_name;
    private LocalDateTime appointment_dateTime;
    private String status;
}
