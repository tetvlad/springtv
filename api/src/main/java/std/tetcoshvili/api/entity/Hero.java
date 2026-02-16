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
    private String attackType;
    private Integer baseHealth;
    private Integer mobility;
    private Integer baseDefense;

    @OneToMany(mappedBy = "hero")
    @JsonIgnore
    private List<Skill> skills;

}
