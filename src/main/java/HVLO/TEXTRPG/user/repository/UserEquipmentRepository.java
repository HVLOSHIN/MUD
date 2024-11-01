package HVLO.TEXTRPG.user.repository;

import HVLO.TEXTRPG.user.entity.UserEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserEquipmentRepository extends JpaRepository<UserEquipment, Long> {
    List<UserEquipment> findByUserId(Long userId);
}
