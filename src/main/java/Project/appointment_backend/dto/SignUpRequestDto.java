package Project.appointment_backend.dto;

import Project.appointment_backend.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {
    private String name;
    private String email;
    private String password;
    private Role role;

    private String phoneNumber;
    private Integer age;
    private String gender;

    private String specialization;
    private Integer experienceYears;
    private String qualification;
}