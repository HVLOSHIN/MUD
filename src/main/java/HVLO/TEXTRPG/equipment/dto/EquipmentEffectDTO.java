package HVLO.TEXTRPG.equipment.dto;

import HVLO.TEXTRPG.global.constants.EffectType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EquipmentEffectDTO {
    private EffectType effectType;
    private Double value;
}
