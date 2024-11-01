package HVLO.TEXTRPG.job.mapper;

import HVLO.TEXTRPG.job.dto.ActiveSkillDTO;
import HVLO.TEXTRPG.job.dto.ActiveSkillEffectDTO;
import HVLO.TEXTRPG.job.entity.ActiveSkill;
import HVLO.TEXTRPG.job.entity.ActiveSkillEffect;

import java.util.List;
import java.util.stream.Collectors;

public class ActiveSkillMapper {
    public static ActiveSkillDTO toDTO(ActiveSkill activeSkill, List<ActiveSkillEffect> effects) {
        ActiveSkillDTO dto = new ActiveSkillDTO();
        dto.setJobId(activeSkill.getJobId());
        dto.setNextSkillId(activeSkill.getNextSkillId());
        dto.setPrevSkillId(activeSkill.getPrevSkillId());
        dto.setSkillLevel(activeSkill.getSkillLevel());
        dto.setName(activeSkill.getName());
        dto.setDescription(activeSkill.getDescription());
        dto.setMastery(activeSkill.getMastery());
        dto.setRequiredAP(activeSkill.getRequiredAP());
        dto.setType(activeSkill.getType());
        dto.setChance(activeSkill.getChance());
        dto.setPriority(activeSkill.getPriority());

        List<ActiveSkillEffectDTO> effectDTOs = effects.stream()
                .map(ActiveSkillEffectMapper::toDTO)
                .collect(Collectors.toList());
        dto.setEffects(effectDTOs);
        return dto;
    }
}
