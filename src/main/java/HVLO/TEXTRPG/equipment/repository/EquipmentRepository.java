package HVLO.TEXTRPG.equipment.repository;

import HVLO.TEXTRPG.equipment.dto.EquipmentDTO;
import HVLO.TEXTRPG.equipment.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

}
