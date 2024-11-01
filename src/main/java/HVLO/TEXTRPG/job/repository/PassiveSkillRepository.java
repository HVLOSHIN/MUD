package HVLO.TEXTRPG.job.repository;

import HVLO.TEXTRPG.job.entity.PassiveSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassiveSkillRepository extends JpaRepository<PassiveSkill, Long> {
    List<PassiveSkill> findAllByJobId(Long jobId);
}
