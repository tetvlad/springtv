package std.tetcoshvili.api.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.UUID;


@Entity
public class Hero {
    @Id
    private UUID id;

    private String name;
    private Integer attack;
    private Integer defense;
    private Integer mobility;
    private Integer health;

    @OneToMany(mappedBy = "hero")
    private List<Skill> skills;
}
