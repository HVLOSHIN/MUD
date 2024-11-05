package HVLO.TEXTRPG.enemy.entity;

import HVLO.TEXTRPG.global.constants.EnemyType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "enemy")
@Getter @Setter
public class Enemy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long fieldId;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
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

    // 기술

}
