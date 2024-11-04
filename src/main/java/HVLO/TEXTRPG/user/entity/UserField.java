package HVLO.TEXTRPG.user.entity;

import HVLO.TEXTRPG.global.constants.FieldStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "user_field")
@AllArgsConstructor
@NoArgsConstructor
public class UserField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long fieldId;

    private FieldStatus fieldStatus;

    public UserField(Long userId, Long fieldId, FieldStatus fieldStatus) {
        this.userId = userId;
        this.fieldId = fieldId;
        this.fieldStatus = fieldStatus;
    }
}
