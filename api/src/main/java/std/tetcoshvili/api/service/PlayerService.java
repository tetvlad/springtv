package std.tetcoshvili.api.service;

import org.springframework.stereotype.Service;
import std.tetcoshvili.api.dao.PlayerInfoDAO;
import std.tetcoshvili.api.dao.TeamDAO;
import std.tetcoshvili.api.entity.PlayerInfo;
import std.tetcoshvili.api.entity.Team;

import java.util.List;
import java.util.UUID;

@Service
public class PlayerService {

    private final PlayerInfoDAO playerDAO;
    private final TeamDAO teamDAO;

    public PlayerService(PlayerInfoDAO playerDAO, TeamDAO teamDAO) {
        this.playerDAO = playerDAO;
        this.teamDAO = teamDAO;
    }

    public List<PlayerInfo> getAllPlayers() {
        return playerDAO.findAll();
    }

    public PlayerInfo getById(UUID id) {
        return playerDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Команда не найдена!!!!"));
    }

    public PlayerInfo create(PlayerInfo player, UUID teamId) {
        if (teamId != null) {
            Team team = teamDAO.findById(teamId)
                    .orElseThrow(() -> new RuntimeException("Команда не найдена!!!!"));
            player.setTeam(team);
        }
        return playerDAO.save(player);
    }

    public PlayerInfo update(UUID id, PlayerInfo updated) {
        PlayerInfo player = getById(id);
        player.setName(updated.getName());
        player.setRole(updated.getRole());
        if (updated.getTeam() != null)
            player.setTeam(updated.getTeam());
        return playerDAO.save(player);
    }

    public void delete(UUID id) {
        playerDAO.deleteById(id);
    }
}