package HVLO.TEXTRPG.user.dto;

import HVLO.TEXTRPG.equipment.dto.EquipmentEffectDTO;
import HVLO.TEXTRPG.global.constants.EquipmentGrade;
import HVLO.TEXTRPG.global.constants.EquipmentSlot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEquipmentDTO {
    private Long id;

    private boolean isEquipped;

    private EquipmentGrade grade;

    private String name;

    private String description;

    private EquipmentSlot slot;

    private List<EquipmentEffectDTO> effects;
}
