package HVLO.TEXTRPG.field.dto;

import HVLO.TEXTRPG.global.constants.FieldType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FieldDTO {

    private Long id;

    private String name;

    private String description;

    private FieldType type;

    private int minLevel;
}
