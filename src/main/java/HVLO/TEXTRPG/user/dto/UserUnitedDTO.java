package HVLO.TEXTRPG.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class UserUnitedDTO {

    private UserStatsDTO userStats;

    private UserAchievementsDTO achievements;

    private List<UserLogDTO> logs;

    private List<UserEquipmentDTO> equipments;

    private List<UserMasteryDTO> mastery;

}
