package HVLO.TEXTRPG.equipment.repository;

import HVLO.TEXTRPG.equipment.dto.EquipmentEffectDTO;
import HVLO.TEXTRPG.equipment.entity.EquipmentEffect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EquipmentEffectRepository extends JpaRepository<EquipmentEffect, Long> {
    Optional<List<EquipmentEffect>> findAllByEquipmentId(Long equipmentId);
}
