package HVLO.TEXTRPG.job.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PassiveSkillDTO {
    private Long jobId;

    private Long passiveId;

    private Long nextSkillId;

    private Long prevSkillId;

    private Integer skillLevel;

    private String name;

    private String description;

    private Integer mastery;

    private Integer requiredAP;

    List<PassiveSkillEffectDTO> effects;
}
