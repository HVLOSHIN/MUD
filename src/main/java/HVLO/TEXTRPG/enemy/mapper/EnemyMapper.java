package HVLO.TEXTRPG.enemy.mapper;

import HVLO.TEXTRPG.enemy.dto.EnemyDTO;
import HVLO.TEXTRPG.enemy.entity.Enemy;
import HVLO.TEXTRPG.item.dto.ItemDTO;

import java.util.List;

public class EnemyMapper {

    public static EnemyDTO toDto(Enemy enemy, List<ItemDTO> items){
        EnemyDTO dto = new EnemyDTO();

        dto.setId(enemy.getId());
        dto.setFieldId(enemy.getFieldId());
        dto.setName(enemy.getName());
        dto.setDescription(enemy.getDescription());
        dto.setEnemyType(enemy.getEnemyType());
        dto.setGiveHP(enemy.getGiveHP());
        dto.setStrength(enemy.getStrength());
        dto.setDexterity(enemy.getDexterity());
        dto.setIntelligence(enemy.getIntelligence());
        dto.setHP(enemy.getHP());
        dto.setPA(enemy.getPA());
        dto.setMA(enemy.getMA());
        dto.setPD(enemy.getPD());
        dto.setMD(enemy.getMD());
        dto.setCT(enemy.getCT());
        dto.setCD(enemy.getCD());
        dto.setAR(enemy.getAR());
        dto.setAV(enemy.getAV());
        dto.setItems(items);

        return dto;
    }
}
