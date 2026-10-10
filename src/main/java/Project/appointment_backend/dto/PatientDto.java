package Project.appointment_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class PatientDto {
    private int id;
    private String Name;
    private String Email;
    private String Phone;
}
