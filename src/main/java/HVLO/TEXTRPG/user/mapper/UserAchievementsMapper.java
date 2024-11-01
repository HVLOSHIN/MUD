package HVLO.TEXTRPG.user.mapper;

import HVLO.TEXTRPG.user.dto.UserAchievementsDTO;
import HVLO.TEXTRPG.user.entity.UserAchievements;

public class UserAchievementsMapper {
    public static UserAchievementsDTO toDTO(UserAchievements userAchievements) {
        UserAchievementsDTO dto = new UserAchievementsDTO();
        dto.setUsedHp(userAchievements.getUsedHp());
        dto.setTotalDamage(userAchievements.getTotalDamage());
        dto.setKillCount(userAchievements.getKillCount());
        dto.setMaxDamage(userAchievements.getMaxDamage());
        dto.setUsedGold(userAchievements.getUsedGold());
        dto.setTotalGold(userAchievements.getTotalGold());
        return dto;
    }
}
