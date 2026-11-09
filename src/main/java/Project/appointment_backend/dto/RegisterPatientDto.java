package Project.appointment_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterPatientDto {
    private String patientName;
    private String patientEmail;
    private String patientPassword;
    private String patientPhone;
}

