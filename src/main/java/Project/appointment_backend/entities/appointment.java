package Project.appointment_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="patient")
@Getter
@Setter

public class appointment {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private int id;
    private String patient_id;
    private String patient_name;
    private String  doctor_id;
    private String doctor_name;
    private LocalDateTime appointment_dateTime;
    private String status;
}
