package HVLO.TEXTRPG.job.repository;

import HVLO.TEXTRPG.job.entity.PassiveSkillEffect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassiveSkillEffectRepository extends JpaRepository<PassiveSkillEffect, Long> {

    Optional<List<PassiveSkillEffect>> findAllBySkillId(Long id);
}
