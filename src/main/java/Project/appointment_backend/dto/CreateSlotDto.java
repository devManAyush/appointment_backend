
package Project.appointment_backend.dto;

import Project.appointment_backend.entities.SlotStatus;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateSlotDto {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private SlotStatus status;
}

