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
    private String doctorName;
    private String patientName;
    private CreateSlotDto slot;
}
