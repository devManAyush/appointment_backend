package Project.appointment_backend;

import Project.appointment_backend.entities.Account;
import Project.appointment_backend.entities.Role;
import Project.appointment_backend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminAccountInitializer implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.admin.email}")
    private String adminEmail;

    @Value("${app.admin.password}")
    private String adminPassword;

    public AdminAccountInitializer(
            AccountRepository accountRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        accountRepository.findByEmail(adminEmail).ifPresentOrElse(
                existingAccount -> {
                    if (existingAccount.getRole() != Role.ADMIN) {
                        throw new IllegalStateException(
                                "Configured admin email is already used by a non-admin account."
                        );
                    }
                },
                () -> {
                    Account admin = new Account();
                    admin.setName("Administrator");
                    admin.setEmail(adminEmail);
                    admin.setPassword(passwordEncoder.encode(adminPassword));
                    admin.setRole(Role.ADMIN);
                    accountRepository.save(admin);
                }
        );
    }
}