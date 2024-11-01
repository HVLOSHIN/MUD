package HVLO.TEXTRPG.user.entity;

import HVLO.TEXTRPG.global.constants.JobStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_mastery")
@Getter @Setter
public class UserMastery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long JobId;

    @Enumerated(EnumType.STRING)
    private JobStatus status;

    private Integer jobMasteryEXP;

    private Long activeSkillId;

    private Integer activeSkillMasteryEXP;

    private Long passiveSkillId;

    private Integer passiveSkillMasteryEXP;

}
