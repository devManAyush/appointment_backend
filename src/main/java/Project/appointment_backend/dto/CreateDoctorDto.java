package Project.appointment_backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class CreateDoctorDto {
    private String name;
    private String mail;
    private String phone;
    private String specialty;
    private int visitingFees;
    private int salary;
    private List<CreateSlotDto> slots;
}
