package HVLO.TEXTRPG.user.repository;

import HVLO.TEXTRPG.user.dto.UserMasteryDTO;
import HVLO.TEXTRPG.user.entity.UserMastery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserMasteryRepository extends JpaRepository<UserMastery, Long> {
    List<UserMastery> findByUserId(Long userId);
}
