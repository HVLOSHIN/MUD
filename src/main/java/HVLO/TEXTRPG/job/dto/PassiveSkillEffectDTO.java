package HVLO.TEXTRPG.job.dto;

import HVLO.TEXTRPG.global.constants.EffectType;
import HVLO.TEXTRPG.global.constants.Operation;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PassiveSkillEffectDTO {
    private EffectType effectType;
    private Double value;
    private Operation operation;
}
