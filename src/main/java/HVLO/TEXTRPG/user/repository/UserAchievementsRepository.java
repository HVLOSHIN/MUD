package HVLO.TEXTRPG.user.repository;

import HVLO.TEXTRPG.user.dto.UserAchievementsDTO;
import HVLO.TEXTRPG.user.entity.UserAchievements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserAchievementsRepository extends JpaRepository<UserAchievements, Long> {
    Optional<UserAchievements> findByUserId(Long userId);

    @Query("SELECT new HVLO.TEXTRPG.user.dto.UserAchievementsDTO(" +
            "ua.usedHp, ua.totalDamage, ua.killCount, ua.maxDamage, " +
            "ua.usedGold, ua.totalGold) " +
            "FROM UserAchievements ua WHERE ua.userId = :userId")
    Optional<UserAchievementsDTO> findUserAchievementsDTOByUserId(@Param("userId") Long userId);
}
