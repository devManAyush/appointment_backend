package Project.appointment_backend.service;

import Project.appointment_backend.dto.CreatePatientDto;
import Project.appointment_backend.entities.Account;
import Project.appointment_backend.entities.Patient;
import Project.appointment_backend.entities.Role;
import Project.appointment_backend.exception.CustomApiException;
import Project.appointment_backend.exception.ErrorCode;
import Project.appointment_backend.repository.AccountRepository;
import Project.appointment_backend.repository.PatientRepository;
import Project.appointment_backend.security.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Project.appointment_backend.dto.LoginRequestDto;
import Project.appointment_backend.dto.LoginResponseDto;
import Project.appointment_backend.entities.Account;
import Project.appointment_backend.exception.CustomApiException;
import Project.appointment_backend.exception.ErrorCode;
import Project.appointment_backend.security.JwtService;

@Service
@AllArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;
    private final PatientRepository patientRepository;
    private final JwtService jwtService;

    @Transactional
    public void signUpUser(CreatePatientDto createPatientDto) {
        if (accountRepository.existsByEmail(createPatientDto.getMail())) {
            throw new CustomApiException(
                    ErrorCode.INVALID_INPUT,
                    "An account with this email already exists."
            );
        }
        Account account = new Account();
        account.setName(createPatientDto.getName());
        account.setEmail(createPatientDto.getMail());
        account.setPassword(passwordEncoder.encode(createPatientDto.getPassword()));
        account.setRole(Role.PATIENT);

        accountRepository.save(account);

        Patient patient = new Patient();
        patient.setName(createPatientDto.getName());
        patient.setMail(createPatientDto.getMail());
        patient.setPhone(createPatientDto.getPhone());
        patient.setAge(createPatientDto.getAge());
        patient.setGender(createPatientDto.getGender());
        patient.setDisease(createPatientDto.getDisease());
        patient.setAccount(account);

        patientRepository.save(patient);
    }

    public LoginResponseDto login(LoginRequestDto request) {
        Account account = accountRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new CustomApiException(
                        ErrorCode.INVALID_CREDENTIALS,
                        "Invalid email or password."
                ));

        if (!passwordEncoder.matches(request.getPassword(), account.getPassword())) {
            throw new CustomApiException(
                    ErrorCode.INVALID_CREDENTIALS,
                    "Invalid email or password."
            );
        }

        String token = jwtService.createToken(account.getEmail(), account.getRole());
        return new LoginResponseDto(token, "Bearer");
    }

}
