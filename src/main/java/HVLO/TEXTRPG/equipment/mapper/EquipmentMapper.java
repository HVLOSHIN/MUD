package HVLO.TEXTRPG.equipment.mapper;

import HVLO.TEXTRPG.equipment.dto.EquipmentDTO;
import HVLO.TEXTRPG.equipment.dto.EquipmentEffectDTO;
import HVLO.TEXTRPG.equipment.entity.Equipment;
import HVLO.TEXTRPG.equipment.entity.EquipmentEffect;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EquipmentMapper {
    public static EquipmentDTO toDTO(Equipment equipment, List<EquipmentEffect> effects) {
        EquipmentDTO dto = new EquipmentDTO();
        dto.setId(equipment.getId());
        dto.setName(equipment.getName());
        dto.setDescription(equipment.getDescription());
        dto.setSlot(equipment.getSlot());

        List<EquipmentEffectDTO> effectDTOs = effects.stream()
                .map(EquipmentEffectMapper::toDTO)
                .collect(Collectors.toList());
        dto.setEffects(effectDTOs);
        return dto;
    }
}
