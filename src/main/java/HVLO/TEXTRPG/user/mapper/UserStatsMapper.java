package HVLO.TEXTRPG.user.mapper;

import HVLO.TEXTRPG.user.dto.UserStatsDTO;
import HVLO.TEXTRPG.user.entity.UserStats;

public class UserStatsMapper {
    public static UserStatsDTO toDto(UserStats stat) {
        UserStatsDTO dto = new UserStatsDTO();
        dto.setLevel(stat.getLevel());
        dto.setGold(stat.getGold());
        dto.setCurrentActionPoints(stat.getCurrentActionPoints());
        dto.setMaxActionPoints(stat.getMaxActionPoints());
        dto.setAP(stat.getAP());
        dto.setHp(stat.getHp());
        dto.setStrength(stat.getStrength());
        dto.setDexterity(stat.getDexterity());
        dto.setIntelligence(stat.getIntelligence());
        return dto;
    }
}
