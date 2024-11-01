package HVLO.TEXTRPG.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAchievementsDTO {

    private int usedHp;

    private long totalDamage;

    private int killCount;

    private int maxDamage;

    private long usedGold;

    private long totalGold;
}
