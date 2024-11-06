package HVLO.TEXTRPG.job.dto;

import HVLO.TEXTRPG.global.constants.SkillType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ActiveSkillDTO {

    private Long jobId;

    private Long nextSkillId;

    private Integer skillLevel;

    private String name;

    private String description;

    private Integer mastery;

    private Integer requiredAP;

    @Enumerated(EnumType.STRING)
    private SkillType type;

    private Integer chance;

    private Integer priority;

    List<ActiveSkillEffectDTO> effects;
}
