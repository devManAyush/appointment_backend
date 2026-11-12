package Project.appointment_backend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class DoctorDto {
    private int id;
    private String name;
    private String mail;
    private String phone;
    private String specialty;
    private int visitingFees;
    private int salary;
    private List<CreateSlotDto> slots;

}
