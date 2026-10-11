package Project.appointment_backend.repository;

import Project.appointment_backend.entities.Doctor;
import Project.appointment_backend.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
