package HVLO.TEXTRPG.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HPUpdateDTO {
    private Long userId;
    private int newHp;
}
