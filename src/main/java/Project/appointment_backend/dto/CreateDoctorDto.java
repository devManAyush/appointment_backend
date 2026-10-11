package Project.appointment_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateDoctorDto {
    private String name;
    private int salary;
    private String availability;
    private String speciality;
}
