package Project.appointment_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="Appointment")
@Getter
@Setter

public class Appointment {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private int id;
    private String patient_name;
    private String  doctor_id;
    private String doctor_name;
    private LocalDateTime appointment_dateTime;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="doctor_id")
    private Doctor doctor;
}
