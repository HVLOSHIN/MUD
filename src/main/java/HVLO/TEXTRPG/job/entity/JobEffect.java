package HVLO.TEXTRPG.job.entity;

import HVLO.TEXTRPG.global.constants.EffectType;
import HVLO.TEXTRPG.global.constants.Operation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "job_effect")
@Getter @Setter
public class JobEffect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @Enumerated(EnumType.STRING)
    private EffectType effectType;

    @Enumerated(EnumType.STRING)
    private Operation operation;

    private Double value;

}
