
package Project.appointment_backend.repository;

import Project.appointment_backend.entities.Slot;
import Project.appointment_backend.entities.SlotStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface SlotRepository extends JpaRepository<Slot, Integer> {

    List<Slot> findByDoctor_Id(int doctorId);
    
    List<Slot> findByDoctor_IdAndStatus(
            int doctorId,
            SlotStatus status
    );
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select s from Slot s where s.id = :slotId")
    Optional<Slot> findByIdForUpdate(@Param("slotId") int slotId);
}
