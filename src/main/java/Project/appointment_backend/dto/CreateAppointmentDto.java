package Project.appointment_backend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAppointmentDto {
    @NotNull(message = "Patient ID is required")
    private Integer patientId;
    @NotNull(message = "Doctor ID is required")
    private Integer doctorId;
    @NotNull(message = "Slot ID is required")
    private Integer slotId;
}
