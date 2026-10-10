package Project.appointment_backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class CreateAppointmentDto {
    private String patient_id;
    private String patient_name;
    private String doctor_id;
    private String doctor_name;
    private LocalDateTime appointment_dateTime;
    private String status;
}
