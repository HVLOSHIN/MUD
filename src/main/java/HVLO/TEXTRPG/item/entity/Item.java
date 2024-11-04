package HVLO.TEXTRPG.item.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long enemyId;

    private String name;

    private String description;

    private int price;

    private int dropRate;
}
