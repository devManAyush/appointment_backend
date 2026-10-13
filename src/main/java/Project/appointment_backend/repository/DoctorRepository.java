package Project.appointment_backend.repository;

import Project.appointment_backend.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    // Custom Native Query demonstrating DBMS filtering & string comparisons
    @Query(value = "SELECT * FROM doctor WHERE specialty = :specialty AND availability = 'AVAILABLE' LIMIT 1",
            nativeQuery = true)
    Optional<Doctor> findFirstAvailableDoctorBySpecialty(@Param("specialty") String specialty);
}
