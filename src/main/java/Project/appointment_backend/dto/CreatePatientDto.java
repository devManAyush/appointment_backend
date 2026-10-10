package Project.appointment_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreatePatientDto {
    private String Name;
    private String Email;
    private String Phone;
}
