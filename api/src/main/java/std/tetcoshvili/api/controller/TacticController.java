package std.tetcoshvili.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import std.tetcoshvili.api.dto.TacticDTO;
import std.tetcoshvili.api.service.TacticService;

import java.util.List;

@RestController
@RequestMapping("/api/tactics")
public class TacticController {

    private final TacticService tacticService;

    public TacticController(TacticService tacticService) {
        this.tacticService = tacticService;
    }

    @GetMapping
    public List<TacticDTO> getAll() {
        return tacticService.getAll();
    }
}

