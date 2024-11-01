package HVLO.TEXTRPG.equipment.mapper;

import HVLO.TEXTRPG.equipment.dto.EquipmentEffectDTO;
import HVLO.TEXTRPG.equipment.entity.EquipmentEffect;

public class EquipmentEffectMapper {
    public static EquipmentEffectDTO toDTO(EquipmentEffect equipmentEffect) {
        EquipmentEffectDTO dto = new EquipmentEffectDTO();
        dto.setEffectType(equipmentEffect.getEffectType());
        dto.setValue(equipmentEffect.getValue());
        return dto;
    }
}
