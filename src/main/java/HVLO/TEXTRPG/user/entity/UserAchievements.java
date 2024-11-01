package HVLO.TEXTRPG.user.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_achievements")
@Getter @Setter
public class UserAchievements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private int usedHp = 0;

    private long totalDamage = 0;

    private int killCount = 0;

    private int maxDamage = 0;

    private long usedGold = 0;

    private long totalGold = 0;

}
