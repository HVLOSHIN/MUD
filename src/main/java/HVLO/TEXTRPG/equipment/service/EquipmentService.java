package HVLO.TEXTRPG.equipment.service;

import HVLO.TEXTRPG.equipment.dto.EquipmentDTO;
import HVLO.TEXTRPG.equipment.entity.Equipment;
import HVLO.TEXTRPG.equipment.entity.EquipmentEffect;
import HVLO.TEXTRPG.equipment.mapper.EquipmentMapper;
import HVLO.TEXTRPG.equipment.repository.EquipmentEffectRepository;
import HVLO.TEXTRPG.equipment.repository.EquipmentRepository;
import HVLO.TEXTRPG.global.constants.ErrorCode;
import HVLO.TEXTRPG.global.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;
    private final EquipmentEffectRepository equipmentEffectRepository;

    public EquipmentDTO findEquipmentById(Long equipmentId) {
        Equipment equipment = equipmentRepository.findById(equipmentId)
                .orElseThrow(() -> new GlobalException(ErrorCode.EQUIPMENT_NOT_FOUND));
        List<EquipmentEffect> effects = equipmentEffectRepository.findAllByEquipmentId(equipmentId)
                .orElseThrow(() -> new GlobalException(ErrorCode.EQUIPMENT_EFFECTS_NOT_FOUND));
        return EquipmentMapper.toDTO(equipment, effects);
    }
}
