package HVLO.TEXTRPG.user.mapper;

import HVLO.TEXTRPG.equipment.dto.EquipmentDTO;
import HVLO.TEXTRPG.user.dto.UserEquipmentDTO;
import HVLO.TEXTRPG.user.entity.UserEquipment;

public class UserEquipmentMapper {
    public static UserEquipmentDTO toDTO(UserEquipment userEquipment, EquipmentDTO equipmentDTO) {
        UserEquipmentDTO dto = new UserEquipmentDTO();
        dto.setId(userEquipment.getId());
        dto.setEquipped(userEquipment.isEquipped());
        dto.setGrade(userEquipment.getGrade());

        dto.setName(equipmentDTO.getName());
        dto.setDescription(equipmentDTO.getDescription());
        dto.setSlot(equipmentDTO.getSlot());
        dto.setEffects(equipmentDTO.getEffects());
        return dto;
    }
}
