package HVLO.TEXTRPG.job.repository;

import HVLO.TEXTRPG.job.entity.JobEffect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobEffectRepository extends JpaRepository<JobEffect, Long> {
    List<JobEffect> findAllByJobId(Long jobId);
}
