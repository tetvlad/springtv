package std.tetcoshvili.api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "skill",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"hero_id", "name"})})
@Data
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "hero_id")
    private Hero hero;
}