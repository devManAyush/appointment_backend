package Project.appointment_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="Doctor")
@Getter
@Setter

public class Doctor {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private int id;
    private String name;
    private String mail;
    private String password;
    private String phone;
    private String specialty;
    private int visitingFees;
    private int salary;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", unique = true)
    private Account account;
    @Enumerated(EnumType.STRING)
    private Role role = Role.DOCTOR;
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments;
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Slot> slots=new ArrayList<>();
}
