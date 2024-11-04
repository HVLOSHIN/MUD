package HVLO.TEXTRPG.enemy.repository;

import HVLO.TEXTRPG.enemy.entity.Enemy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnemyRepository extends JpaRepository<Enemy, Long> {
    List<Enemy> findEnemiesByFieldId(Long fieldId);
}
