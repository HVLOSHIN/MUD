package HVLO.TEXTRPG.equipment.dto;

import HVLO.TEXTRPG.global.constants.EquipmentSlot;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class EquipmentDTO {
    private Long id;
    private String name;
    private String description;
    private EquipmentSlot slot;
    private List<EquipmentEffectDTO> effects;
}
