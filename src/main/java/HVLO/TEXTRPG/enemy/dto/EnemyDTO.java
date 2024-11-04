package HVLO.TEXTRPG.enemy.dto;

import HVLO.TEXTRPG.global.constants.EnemyType;
import HVLO.TEXTRPG.item.dto.ItemDTO;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class EnemyDTO {

    private Long id;

    private Long fieldId;

    private String name;

    private String description;

    private EnemyType enemyType;

    private int giveHP;

    private int strength;

    private int dexterity;

    private int intelligence;

    private int HP;

    private int PA;

    private int MA;

    private int PD;

    private int MD;

    private int CT;

    private int CD;

    private int AR;

    private int AV;

    private List<ItemDTO> items;
}
