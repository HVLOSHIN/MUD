package HVLO.TEXTRPG.user.entity;

import HVLO.TEXTRPG.global.constants.JobStatus;
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

    private Long JobId;

    @Enumerated(EnumType.STRING)
    private JobStatus status = JobStatus.NOT_STARTED;

    private Integer jobMasteryEXP = 0;

    private Long activeSkillId;

    private Integer activeSkillMasteryEXP = 0;

    private Long passiveSkillId;

    private Integer passiveSkillMasteryEXP = 0;


    public UserMastery(Long userId, Long jobId, JobStatus status, Long activeSkillId, Long passiveSkillId) {
        this.userId = userId;
        JobId = jobId;
        this.status = status;
        this.activeSkillId = activeSkillId;
        this.passiveSkillId = passiveSkillId;
    }
}
