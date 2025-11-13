package std.tetcoshvili.api.controller;

import org.springframework.web.bind.annotation.*;
import std.tetcoshvili.api.entity.Team;
import std.tetcoshvili.api.service.TeamService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

       public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> getAll() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public Team getById(@PathVariable UUID id) {
        return teamService.getById(id);
    }

    @PostMapping
    public Team create(@RequestBody Team team) {
        return teamService.create(team);
    }

    @PutMapping("/{id}")
    public Team update(@PathVariable UUID id, @RequestBody Team team) {
        return teamService.update(id, team);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        teamService.delete(id);
    }
}