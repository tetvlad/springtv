package std.tetcoshvili.api.controller;

import org.springframework.web.bind.annotation.*;
import std.tetcoshvili.api.dto.TacticCardDTO;
import std.tetcoshvili.api.dto.TacticDTO;
import std.tetcoshvili.api.mapper.TacticCardMapper;
import std.tetcoshvili.api.mapper.TacticMapper;
import std.tetcoshvili.api.service.TacticService;

import java.util.List;

@RestController
@RequestMapping("/api/tactic-cards")
public class TacticCardController {

    private final TacticService tacticCardService;

    private final TacticCardMapper tacticCardMapper;
    ;

    public TacticCardController(TacticService tacticCardService, TacticMapper tacticMapper, TacticCardMapper tacticCardMapper) {
        this.tacticCardService = tacticCardService;
        this.tacticCardMapper = tacticCardMapper;
    }

    @GetMapping
    public List<TacticDTO> getAll() {
        return tacticCardService.getAll();
    }
}
