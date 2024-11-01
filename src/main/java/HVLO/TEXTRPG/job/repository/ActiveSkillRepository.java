package HVLO.TEXTRPG.job.repository;

import HVLO.TEXTRPG.job.entity.ActiveSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActiveSkillRepository extends JpaRepository<ActiveSkill, Long> {
    List<ActiveSkill> findAllByJobId(Long jobId);
}
