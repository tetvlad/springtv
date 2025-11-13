package std.tetcoshvili.api.service;

import org.springframework.stereotype.Service;
import std.tetcoshvili.api.dao.TeamDAO;
import std.tetcoshvili.api.entity.Team;

import java.util.List;
import java.util.UUID;

@Service
public class TeamService {

    private final TeamDAO teamDAO;

    public TeamService(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    public List<Team> getAllTeams() {
        return teamDAO.findAll();
    }

    public Team getById(UUID id) {
        return teamDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Team not found"));
    }

    public Team create(Team team) {
        return teamDAO.save(team);
    }

    public Team update(UUID id, Team updated) {
        Team team = getById(id);
        team.setTeamName(updated.getTeamName());
        team.setMaxTeamSize(updated.getMaxTeamSize());
        team.setTactics(updated.getTactics());
        return teamDAO.save(team);
    }

    public void delete(UUID id) {
        teamDAO.deleteById(id);
    }
}