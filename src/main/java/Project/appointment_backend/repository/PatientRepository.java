package Project.appointment_backend.repository;

import Project.appointment_backend.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
