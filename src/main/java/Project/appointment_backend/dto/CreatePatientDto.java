package Project.appointment_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreatePatientDto {
    private String name;
    private String mail;
    private String phone;
    private Integer  age;
    private String gender;
    private String disease;
}
