package HVLO.TEXTRPG.job.repository;

import HVLO.TEXTRPG.job.entity.ActiveSkillEffect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActiveSkillEffectRepository extends JpaRepository<ActiveSkillEffect, Long> {
    Optional<List<ActiveSkillEffect>> findAllBySkillId(Long id);
}
