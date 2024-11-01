package HVLO.TEXTRPG.job.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "job")
@Getter @Setter
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Integer requiredStr;

    private Integer requiredDex;

    private Integer requiredInt;

    private Integer mastery;

}
