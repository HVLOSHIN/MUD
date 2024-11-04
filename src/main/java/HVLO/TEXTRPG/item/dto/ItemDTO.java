package HVLO.TEXTRPG.item.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemDTO {

    private Long enemyId;

    private String name;

    private String description;

    private int price;

    private int dropRate;
}
