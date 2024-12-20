package HVLO.TEXTRPG.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class UserDTO {
    private Long userid;

    private String username;

    private UserStatsDTO userStats;

    private UserAchievementsDTO achievements;

    private List<UserLogDTO> logs;

    private List<UserFieldDTO> fields;

    private List<UserEquipmentDTO> equipments;

    private List<UserMasteryDTO> mastery;

   private UserCombatDTO combat;

}
