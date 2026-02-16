package std.tetcoshvili.api.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
