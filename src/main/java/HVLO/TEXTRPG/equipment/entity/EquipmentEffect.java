package HVLO.TEXTRPG.equipment.entity;

import HVLO.TEXTRPG.global.constants.EffectType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="equipment_effect")
@Getter @Setter
public class EquipmentEffect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private Long equipmentId;

    @Enumerated(EnumType.STRING)
    private EffectType effectType;

    private Double value;
}
