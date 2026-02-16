package std.tetcoshvili.api.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import std.tetcoshvili.api.dto.TacticDTO;
import std.tetcoshvili.api.entity.Tactics;
import std.tetcoshvili.api.service.TacticService;

import java.util.List;

@RestController
@RequestMapping("/api/tactics")
public class TacticController {

    private final TacticService tacticService;

    public TacticController(TacticService tacticService) {
        this.tacticService = tacticService;
    }

    @PostMapping
    public Tactics create(@RequestBody @Valid TacticDTO tactics) {
        return tacticService.createTactic(tactics);   }



    @GetMapping
    public List<TacticDTO> getAll() {
        return tacticService.getAll();
    }
}

