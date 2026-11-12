package Project.appointment_backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class CreateDoctorDto {
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @Email(message = "Please provide a valid email address")
    @NotBlank(message = "Email is required")
    private String mail;
    private String initialPassword;
    @NotBlank(message = "Phone number is required")
    private String phone;
    @NotBlank(message = "Specialty is required")
    private String specialty;
    @NotNull(message = "Please enter the VisitingFees")
    private int visitingFees;
    @NotNull(message = "Please enter salary")
    private int salary;
    private List<CreateSlotDto> slots;
}
