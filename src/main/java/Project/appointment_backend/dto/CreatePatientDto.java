package Project.appointment_backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreatePatientDto {
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @Email(message = "Please provide a valid email address")
    @NotBlank(message = "Email is required")
    private String mail;
    @NotBlank(message = "Password is required")
    private String password;
    @NotBlank(message = "Phone number is required")
    private String phone;
    @Min(value = 0, message = "Age must be a positive number")
    private Integer  age;
    private String gender;
    private String disease;
}
