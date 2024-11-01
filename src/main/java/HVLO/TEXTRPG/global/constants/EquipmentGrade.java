package HVLO.TEXTRPG.global.constants;

import lombok.Getter;

@Getter
public enum EquipmentGrade {
    RUBBISH(0.8, 25),
    COMMON(1.0, 30),
    RARE(1.2, 25),
    EPIC(1.5, 15),
    UNIQUE(2, 4),
    LEGENDARY(4,1);

    private final double multiplier; // 배율 값
    private final int dropRate; // 드랍률

    EquipmentGrade(double multiplier, int dropRate) {
        this.multiplier = multiplier;
        this.dropRate = dropRate;
    }
}
