package HVLO.TEXTRPG.user.repository;

import HVLO.TEXTRPG.user.dto.ActionPointDTO;
import HVLO.TEXTRPG.user.dto.UserStatsDTO;
import HVLO.TEXTRPG.user.entity.UserStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserStatsRepository extends JpaRepository<UserStats, Long> {
    Optional<UserStats> findByUserId(Long userId);

    @Query("SELECT new HVLO.TEXTRPG.user.dto.UserStatsDTO(" +
            "us.level, us.gold, us.currentActionPoints, us.maxActionPoints, " +
            "us.AP, us.hp, us.strength, us.dexterity, us.intelligence) " +
            "FROM UserStats us WHERE us.userId = :userId")
    Optional<UserStatsDTO> findUserStatsDTOByUserId(@Param("userId") Long userId);


    @Query("SELECT new HVLO.TEXTRPG.user.dto.ActionPointDTO(" +
            "us.userId, us.currentActionPoints, us.maxActionPoints)" +
            "FROM UserStats  us WHERE us.userId = :userId")
    Optional<ActionPointDTO> findActionPointDTOByUserId(@Param("userId") Long userId);


    @Query("SELECT new HVLO.TEXTRPG.user.dto.LevelUpDTO(" +
            "us.level, us.hp, us.strength, us.dexterity, us.intelligence)" +
            "FROM UserStats  us WHERE us.userId = :userId")
    Optional<ActionPointDTO> findLevelUpDTOByUserId(@Param("userId") Long userId);

}
