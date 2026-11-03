package Project.appointment_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAppointmentDto {
    private Integer patientId;
    private Integer doctorId;
    private Integer slotId;
}
