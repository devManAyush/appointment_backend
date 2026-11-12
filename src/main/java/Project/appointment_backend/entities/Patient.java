package Project.appointment_backend.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.jspecify.annotations.Nullable;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="Patient")
@Getter @Setter


public class Patient {
    @Id
    @GeneratedValue(strategy =
    GenerationType.IDENTITY)
    private int id;
    private String name;
    private String mail;
    private String password;
    private String phone;
    private int age;
    private String gender;
    private String disease;
    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_PATIENT;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", unique = true)
    private Account account;

}
