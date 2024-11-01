package HVLO.TEXTRPG.job.dto;

import HVLO.TEXTRPG.global.constants.EffectType;
import HVLO.TEXTRPG.global.constants.Operation;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JobEffectDTO {
    private EffectType effectType;
    private Operation operation;
    private Double value;
}
