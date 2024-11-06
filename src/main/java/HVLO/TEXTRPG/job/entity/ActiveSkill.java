package HVLO.TEXTRPG.job.entity;

import HVLO.TEXTRPG.global.constants.SkillType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "active_skill")
@Getter @Setter
public class ActiveSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long jobId;

    private Long nextSkillId;

    private Integer skillLevel;

    private String name;

    private String description;

    private Integer mastery;

    private Integer requiredAP;

    @Enumerated(EnumType.STRING)
    private SkillType type;  // 스킬 발동 종류

    private Integer chance; // 발동 확률

    private Integer priority; // 발동 우선순위

}
