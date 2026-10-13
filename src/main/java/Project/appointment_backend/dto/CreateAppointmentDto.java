package Project.appointment_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAppointmentDto {
    private String patientName;
    private String patientEmail;
    private String patientPhone;
    private String specialty;
    private String appointmentDate;
}
