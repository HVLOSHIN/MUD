package HVLO.TEXTRPG.field.mapper;

import HVLO.TEXTRPG.field.dto.FieldDTO;
import HVLO.TEXTRPG.field.entity.Field;

public class FieldMapper {

    public static FieldDTO toDTO(Field field) {
        FieldDTO dto = new FieldDTO();

        dto.setId(field.getId());
        dto.setNextFieldId(field.getNextFieldId());
        dto.setName(field.getName());
        dto.setDescription(field.getDescription());
        dto.setType(field.getType());
        dto.setMinLevel(field.getMinLevel());
        return dto;
    }
}
