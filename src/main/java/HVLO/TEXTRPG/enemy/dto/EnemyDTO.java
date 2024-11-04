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

    private double HP;

    private double PA;

    private double MA;

    private double PD;

    private double MD;

    private double CT;

    private double CD;

    private double AR;

    private double AV;

    private List<ItemDTO> items;
}
