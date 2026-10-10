package Project.appointment_backend.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Patient")
@Getter @Setter


public class Patient {
    @Id
    @GeneratedValue(strategy =
    GenerationType.IDENTITY)
    private int id;
    private String Name;
    private String Email;
    private String Phone;
}
