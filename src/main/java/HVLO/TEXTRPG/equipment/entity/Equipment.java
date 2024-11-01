package HVLO.TEXTRPG.equipment.entity;

import HVLO.TEXTRPG.user.entity.UserEquipment;
import HVLO.TEXTRPG.global.constants.EquipmentSlot;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "equipment")
@Getter @Setter
public class Equipment {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    // 장착 부위
    @Enumerated(EnumType.STRING)
    private EquipmentSlot slot;
}
