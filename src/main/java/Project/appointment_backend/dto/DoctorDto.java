package Project.appointment_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class DoctorDto {
    private int id;
    private String doctorName;
    private String specialty;
    private String availability;
}
