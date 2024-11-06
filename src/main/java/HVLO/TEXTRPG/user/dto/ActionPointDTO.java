package HVLO.TEXTRPG.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActionPointDTO {
    private Long userId;

    private int currentActionPoints;

    private int maxActionPoints;
}
