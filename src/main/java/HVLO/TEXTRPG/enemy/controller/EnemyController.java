package HVLO.TEXTRPG.enemy.controller;

import HVLO.TEXTRPG.enemy.dto.EnemyDTO;
import HVLO.TEXTRPG.enemy.entity.Enemy;
import HVLO.TEXTRPG.enemy.service.EnemyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/enemy")
public class EnemyController {
    private final EnemyService enemyService;

    @GetMapping("/field/{fieldId}")
    public ResponseEntity<List<EnemyDTO>> getEnemies(@PathVariable Long fieldId) {
        return ResponseEntity.status(HttpStatus.OK).body(enemyService.findEnemiesByFieldId(fieldId));
    }

    @GetMapping("/{enemyId}")
    public ResponseEntity<EnemyDTO> getEnemy(@PathVariable Long enemyId){
        return ResponseEntity.status(HttpStatus.OK).body(enemyService.findEnemy(enemyId));
    }
}
