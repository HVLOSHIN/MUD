package HVLO.TEXTRPG.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class LevelUpDTO {

    private int level;

    private int hp;

    private int strength;

    private int dexterity;

    private int intelligence;
}
