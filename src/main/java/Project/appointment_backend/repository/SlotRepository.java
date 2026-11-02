
package Project.appointment_backend.repository;

import Project.appointment_backend.entities.Slot;
import Project.appointment_backend.entities.SlotStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, Integer> {

    List<Slot> findByDoctor_Id(int doctorId);
    
    List<Slot> findByDoctor_IdAndStatus(
            int doctorId,
            SlotStatus status
    );
}
