package std.tetcoshvili.api.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class TacticCard {


    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Hero hero;
    @ManyToOne
    private PlayerInfo playerInfo;
    @ManyToOne
    private Tactics tactics;
}
