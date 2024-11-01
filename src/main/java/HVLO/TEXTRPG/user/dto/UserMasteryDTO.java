package HVLO.TEXTRPG.user.dto;

import HVLO.TEXTRPG.global.constants.JobStatus;
import HVLO.TEXTRPG.job.dto.JobDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class UserMasteryDTO {
    private Long userId;

    private Long JobId;

    private JobStatus status;

    private Integer jobMasteryEXP;

    private Long activeSkillId;

    private Integer activeSkillMasteryEXP;

    private Long passiveSkillId;

    private Integer passiveSkillMasteryEXP;

    private JobDTO job;
}
