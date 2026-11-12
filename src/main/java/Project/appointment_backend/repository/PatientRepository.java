package Project.appointment_backend.repository;

import Project.appointment_backend.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
    Optional<Patient> findByAccount_Email(String email);
}
