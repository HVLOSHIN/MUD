package HVLO.TEXTRPG.job.entity;

import HVLO.TEXTRPG.global.constants.EffectType;
import HVLO.TEXTRPG.global.constants.Operation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "active_skill_effect")
@Getter @Setter
public class ActiveSkillEffect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long skillId;

    @Enumerated(EnumType.STRING)
    private EffectType effectType;

    @Enumerated(EnumType.STRING)
    private Operation operation;

    private Double value;
}
