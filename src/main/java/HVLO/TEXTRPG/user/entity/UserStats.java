package HVLO.TEXTRPG.user.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_stats")
@Getter @Setter
public class UserStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private int gold = 0;

    private int currentActionPoints = 100;

    private int maxActionPoints = 100;

    private int level = 1;

    private int AP = 5;

    private int hp = 10;

    private int strength = 10;

    private int dexterity = 10;

    private int intelligence = 10;

}
