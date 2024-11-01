package HVLO.TEXTRPG.job.mapper;

import HVLO.TEXTRPG.job.dto.ActiveSkillEffectDTO;
import HVLO.TEXTRPG.job.entity.ActiveSkillEffect;

public class ActiveSkillEffectMapper {
    public static ActiveSkillEffectDTO toDTO(ActiveSkillEffect effect) {
        ActiveSkillEffectDTO dto = new ActiveSkillEffectDTO();
        dto.setEffectType(effect.getEffectType());
        dto.setValue(effect.getValue());
        dto.setOperation(effect.getOperation());
        return dto;
    }
}
