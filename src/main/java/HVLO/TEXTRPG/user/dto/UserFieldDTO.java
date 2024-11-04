package HVLO.TEXTRPG.user.dto;

import HVLO.TEXTRPG.global.constants.FieldStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserFieldDTO {

    private Long userId;

    private Long fieldId;

    private FieldStatus fieldStatus;

}
