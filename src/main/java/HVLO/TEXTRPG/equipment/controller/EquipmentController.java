package HVLO.TEXTRPG.equipment.controller;

import HVLO.TEXTRPG.equipment.dto.EquipmentDTO;
import HVLO.TEXTRPG.equipment.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/equipment")
@RequiredArgsConstructor
public class EquipmentController {
    private final EquipmentService equipmentService;

    @GetMapping
    public ResponseEntity<EquipmentDTO> getEquipment() {
        return ResponseEntity.ok( equipmentService.findEquipmentById(1L));
    }
}
