
package Project.appointment_backend.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateSlotDto {

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}

