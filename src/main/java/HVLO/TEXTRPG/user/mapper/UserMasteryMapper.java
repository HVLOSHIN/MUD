package HVLO.TEXTRPG.user.mapper;

import HVLO.TEXTRPG.job.dto.JobDTO;
import HVLO.TEXTRPG.user.dto.UserMasteryDTO;
import HVLO.TEXTRPG.user.entity.UserMastery;

public class UserMasteryMapper {
    public static UserMasteryDTO toDTO(UserMastery userMastery, JobDTO jobDTO) {
        UserMasteryDTO dto = new UserMasteryDTO();
        dto.setUserId(userMastery.getUserId());
        dto.setJobId(userMastery.getJobId());
        dto.setJobStatus(userMastery.getJobStatus());
        dto.setPassiveSkillStatus(userMastery.getPassiveSkillStatus());
        dto.setActiveSkillStatus(userMastery.getActiveSkillStatus());
        dto.setJobMasteryEXP(userMastery.getJobMasteryEXP());
        dto.setActiveSkillId(userMastery.getActiveSkillId());
        dto.setActiveSkillMasteryEXP(userMastery.getActiveSkillMasteryEXP());
        dto.setPassiveSkillId(userMastery.getPassiveSkillId());
        dto.setPassiveSkillMasteryEXP(userMastery.getPassiveSkillMasteryEXP());
        dto.setJob(jobDTO);
        return dto;
    }
}
