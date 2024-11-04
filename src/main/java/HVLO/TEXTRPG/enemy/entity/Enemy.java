package HVLO.TEXTRPG.enemy.entity;

import HVLO.TEXTRPG.global.constants.EnemyType;
import jakarta.persistence.*;

@Entity
@Table(name = "enemy")
public class Enemy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
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

    // 기술

}
