package HVLO.TEXTRPG.enemy.service;

import HVLO.TEXTRPG.enemy.dto.EnemyDTO;
import HVLO.TEXTRPG.enemy.entity.Enemy;
import HVLO.TEXTRPG.enemy.mapper.EnemyMapper;
import HVLO.TEXTRPG.enemy.repository.EnemyRepository;
import HVLO.TEXTRPG.global.constants.ErrorCode;
import HVLO.TEXTRPG.global.exception.GlobalException;
import HVLO.TEXTRPG.item.dto.ItemDTO;
import HVLO.TEXTRPG.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnemyService {
    private final EnemyRepository enemyRepository;
    private final ItemService itemService;

    public EnemyDTO findEnemy(Long enemyId){
        Enemy enemy = enemyRepository.findById(enemyId)
                .orElseThrow(() -> new GlobalException(ErrorCode.ENEMY_NOT_FOUND));
        List<ItemDTO> items = itemService.getItemsByEnemyId(enemyId);
        return EnemyMapper.toDto(enemy, items);
    }

    public List<EnemyDTO> findEnemiesByFieldId(Long fieldId) {
        return enemyRepository.findEnemiesByFieldId(fieldId).stream()
                .map(enemy -> {List<ItemDTO> items = itemService.getItemsByEnemyId(enemy.getId());
                    return EnemyMapper.toDto(enemy, items);})
                .collect(Collectors.toList());
    }
}
