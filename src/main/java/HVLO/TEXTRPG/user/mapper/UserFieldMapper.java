package HVLO.TEXTRPG.user.mapper;

import HVLO.TEXTRPG.user.dto.UserFieldDTO;
import HVLO.TEXTRPG.user.entity.UserField;

public class UserFieldMapper {
    public static UserFieldDTO toDTO(UserField userField) {
        UserFieldDTO dto = new UserFieldDTO();
        dto.setUserId(userField.getUserId());
        dto.setFieldId(userField.getFieldId());
        dto.setFieldStatus(userField.getFieldStatus());
        return dto;
    }
}
