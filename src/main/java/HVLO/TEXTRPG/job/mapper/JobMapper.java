package HVLO.TEXTRPG.job.mapper;

import HVLO.TEXTRPG.job.dto.ActiveSkillDTO;
import HVLO.TEXTRPG.job.dto.JobDTO;
import HVLO.TEXTRPG.job.dto.PassiveSkillDTO;
import HVLO.TEXTRPG.job.entity.*;

import java.util.List;
import java.util.stream.Collectors;

public class JobMapper {
    public static JobDTO toDTO(Job job,
                               List<PassiveSkillDTO> passiveSkills,
                               List<ActiveSkillDTO> activeSkills,
                               List<JobEffect> jobEffects){
        JobDTO dto = new JobDTO();

        dto.setName(job.getName());
        dto.setDescription(job.getDescription());
        dto.setRequiredStr(job.getRequiredStr());
        dto.setRequiredDex(job.getRequiredDex());
        dto.setRequiredInt(job.getRequiredInt());
        dto.setMastery(job.getMastery());

        dto.setEffects(jobEffects.stream()
                .map(JobEffectMapper::toDTO)
                .collect(Collectors.toList()));

        dto.setActiveSkills(activeSkills);
        dto.setPassiveSkills(passiveSkills);


        return dto;
    }
}
