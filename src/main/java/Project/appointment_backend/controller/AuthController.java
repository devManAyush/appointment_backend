package Project.appointment_backend.controller;

import Project.appointment_backend.dto.CreatePatientDto;
import Project.appointment_backend.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@Valid @RequestBody CreatePatientDto createPatientDto) {
        authService.signUpUser(createPatientDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
