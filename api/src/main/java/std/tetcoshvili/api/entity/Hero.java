package std.tetcoshvili.api.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer attack;
    private Integer defense;
    private Integer mobility;
    private Integer health;

    @OneToMany(mappedBy = "hero")
    @JsonIgnore
    private List<Skill> skills;

}
