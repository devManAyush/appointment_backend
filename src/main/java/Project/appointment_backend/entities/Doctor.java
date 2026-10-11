package Project.appointment_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Doctor")
@Getter
@Setter

public class Doctor {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private int id;
    private String Name;
    private String specialty;
    private String availability;
    private int salary;




//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="appointment_id")
//    private Appointment appointment;
}
