package std.tetcoshvili.api.controller;

import org.springframework.web.bind.annotation.*;
import std.tetcoshvili.api.service.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/test")
    public String test() {
        return "Controller works!";
    }
}