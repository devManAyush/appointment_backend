package Project.appointment_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class PatientDto {
    private int id;
    private String name;
    private String email;
    private String phone;
    private int  age;
    private String gender;
    private String disease;
}
