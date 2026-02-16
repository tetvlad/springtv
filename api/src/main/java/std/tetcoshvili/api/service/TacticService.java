package std.tetcoshvili.api.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import std.tetcoshvili.api.dao.TacticDAO;
import std.tetcoshvili.api.dto.TacticDTO;
import std.tetcoshvili.api.entity.Tactics;
import std.tetcoshvili.api.mapper.TacticMapper;

import java.util.List;

@Service
public class TacticService {

    private final TacticDAO tacticDAO;
    private final TacticMapper tacticMapper;

    public TacticService(TacticDAO tacticDAO, TacticMapper tacticMapper) {
        this.tacticDAO = tacticDAO;
        this.tacticMapper = tacticMapper;
    }

    @Transactional
    public Tactics createTactic(TacticDTO tacticDTO) {
        return tacticDAO.save(tacticMapper.toTactic(tacticDTO));
    }
    @Transactional
    public List<TacticDTO> getAll() {
        List<Tactics> tactics = tacticDAO.findAll();
        return tacticMapper.fromTactics(tactics);
    }
}
