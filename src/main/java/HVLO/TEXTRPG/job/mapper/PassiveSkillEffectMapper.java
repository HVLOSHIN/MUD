package HVLO.TEXTRPG.job.mapper;

import HVLO.TEXTRPG.job.dto.PassiveSkillEffectDTO;
import HVLO.TEXTRPG.job.entity.PassiveSkillEffect;

public class PassiveSkillEffectMapper {
    public static PassiveSkillEffectDTO toDTO(PassiveSkillEffect effect) {
        PassiveSkillEffectDTO dto = new PassiveSkillEffectDTO();
        dto.setEffectType(effect.getEffectType());
        dto.setValue(effect.getValue());
        dto.setOperation(effect.getOperation());
        return dto;
    }
}
