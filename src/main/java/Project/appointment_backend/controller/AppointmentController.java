package Project.appointment_backend.controller;

import Project.appointment_backend.dto.AppointmentDto;
import Project.appointment_backend.dto.CreateAppointmentDto;
import Project.appointment_backend.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointment")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentDto> bookAppointment(@Valid @RequestBody CreateAppointmentDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.bookAppointment(dto));
    }
}
