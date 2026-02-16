package std.tetcoshvili.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
public class HeroPick {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hero_id")
    private Hero hero;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerInfo player;

    @ManyToOne
    @JoinColumn(name = "tactic_id")
    private Tactics tactics;
}