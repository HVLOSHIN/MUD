package HVLO.TEXTRPG.job.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "passive_skill")
@Getter @Setter
public class PassiveSkill {
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
}
