package std.tetcoshvili.api.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Team {

    @Id
    @GeneratedValue
    private Long teamId;

    private String teamName;
    private Integer maxTeamSize;
    private String tactics;

    @OneToMany(mappedBy = "team")
    private List<PlayerInfo> players = new ArrayList<>();

    public Team() {}

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getMaxTeamSize() {
        return maxTeamSize;
    }

    public void setMaxTeamSize(Integer maxTeamSize) {
        this.maxTeamSize = maxTeamSize;
    }

    public String getTactics() {
        return tactics;
    }

    public void setTactics(String tactics) {
        this.tactics = tactics;
    }

    public List<PlayerInfo> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerInfo> players) {
        this.players = players;
    }
}