package HVLO.TEXTRPG.user.entity;

import HVLO.TEXTRPG.equipment.entity.Equipment;
import HVLO.TEXTRPG.global.constants.EquipmentGrade;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_equipment")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long userId;

    @NotNull
    private Long equipmentId;


    private boolean isEquipped = false;

    // 등급
    @Enumerated(EnumType.STRING)
    private EquipmentGrade grade;

    public UserEquipment(Long userId, Long equipmentId, boolean isEquipped, EquipmentGrade grade) {
        this.userId = userId;
        this.equipmentId = equipmentId;
        this.isEquipped = isEquipped;
        this.grade = grade;
    }
}
