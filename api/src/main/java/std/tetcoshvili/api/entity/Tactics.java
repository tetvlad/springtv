package std.tetcoshvili.api.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Tactics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tacticId;

    private String name;
    private String description;

    @OneToMany(mappedBy = "tactics")
    //private List<HeroPick> heroPicks;
    private List<TacticCard> tacticCards;
}
