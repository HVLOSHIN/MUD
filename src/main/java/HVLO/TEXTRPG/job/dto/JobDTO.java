package HVLO.TEXTRPG.job.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class JobDTO {

    private String name;

    private String description;

    private Integer requiredStr;

    private Integer requiredDex;

    private Integer requiredInt;

    private Integer mastery;

    List<JobEffectDTO> effects;

    PassiveSkillDTO passiveSkills;

    ActiveSkillDTO activeSkills;
}
