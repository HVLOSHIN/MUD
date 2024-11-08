package HVLO.TEXTRPG.user.repository;

import HVLO.TEXTRPG.user.entity.UserMastery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMasteryRepository extends JpaRepository<UserMastery, Long> {
    List<UserMastery> findByUserId(Long userId);

    UserMastery findByUserIdAndJobId(Long userId, Long jobId);
}
