package HVLO.TEXTRPG.job.mapper;

import HVLO.TEXTRPG.job.dto.PassiveSkillDTO;
import HVLO.TEXTRPG.job.dto.PassiveSkillEffectDTO;
import HVLO.TEXTRPG.job.entity.PassiveSkill;
import HVLO.TEXTRPG.job.entity.PassiveSkillEffect;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PassiveSkillMapper {
    public static PassiveSkillDTO toDTO(PassiveSkill passiveSkill, List<PassiveSkillEffect> effects) {
        PassiveSkillDTO dto = new PassiveSkillDTO();
        dto.setJobId(passiveSkill.getJobId());
        dto.setNextSkillId(passiveSkill.getNextSkillId());
        dto.setPrevSkillId(passiveSkill.getPrevSkillId());
        dto.setSkillLevel(passiveSkill.getSkillLevel());
        dto.setName(passiveSkill.getName());
        dto.setDescription(passiveSkill.getDescription());
        dto.setMastery(passiveSkill.getMastery());
        dto.setRequiredAP(passiveSkill.getRequiredAP());

        List<PassiveSkillEffectDTO> effectDTOs = effects.stream()
                .map(PassiveSkillEffectMapper::toDTO)
                .collect(Collectors.toList());
        dto.setEffects(effectDTOs);
        return dto;
    }
}
