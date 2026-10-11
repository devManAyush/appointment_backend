package Project.appointment_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name="QueueEntryService")
@Getter
@Setter

public class QueueEntry {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private int id;
    private String patient_id;
    private String patient_name;
    private String  doctor_id;
    private String doctor_name;
    private LocalDateTime joinedAt;
    private String tokenNumber;
    private String status;
}
