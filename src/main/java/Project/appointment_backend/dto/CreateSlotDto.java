
package Project.appointment_backend.dto;

import Project.appointment_backend.entities.SlotStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateSlotDto {
    private Integer id;
    @NotBlank(message = "Please enter Timing")
    private LocalDateTime startTime;
    @NotBlank(message = "Please enter Timing")
    private LocalDateTime endTime;
    private SlotStatus status;
}

