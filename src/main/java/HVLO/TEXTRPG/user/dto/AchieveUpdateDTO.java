package HVLO.TEXTRPG.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AchieveUpdateDTO {
    private Long userId;

    private int totalDamage;

    private int maxDamage;

    private int killCount;

}