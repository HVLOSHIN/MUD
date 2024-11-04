package HVLO.TEXTRPG.field.entity;

import HVLO.TEXTRPG.global.constants.FieldType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Field")
@Getter @Setter
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private FieldType type;

    private int minLevel;

    private Long nextFieldId;

}
