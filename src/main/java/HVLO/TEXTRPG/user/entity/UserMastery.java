package HVLO.TEXTRPG.user.entity;

import HVLO.TEXTRPG.global.constants.JobStatus;
import HVLO.TEXTRPG.global.constants.SkillStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_mastery")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserMastery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long jobId;

    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus = JobStatus.NOT_STARTED;

    @Enumerated(EnumType.STRING)
    private SkillStatus passiveSkillStatus = SkillStatus.NOT_STARTED;

    @Enumerated(EnumType.STRING)
    private SkillStatus activeSkillStatus = SkillStatus.NOT_STARTED;

    private Integer jobMasteryEXP = 0;

    private Long activeSkillId;

    private Integer activeSkillMasteryEXP = 0;

    private Long passiveSkillId;

    private Integer passiveSkillMasteryEXP = 0;


    public UserMastery(Long userId, Long jobId, JobStatus status, Long activeSkillId, Long passiveSkillId, SkillStatus passiveSkillStatus, SkillStatus activeSkillStatus) {
        this.userId = userId;
        this.jobId = jobId;
        this.jobStatus = status;
        this.activeSkillId = activeSkillId;
        this.passiveSkillId = passiveSkillId;
        this.passiveSkillStatus = passiveSkillStatus;
        this.activeSkillStatus = activeSkillStatus;
    }
}
