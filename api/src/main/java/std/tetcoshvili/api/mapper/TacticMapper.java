package std.tetcoshvili.api.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import std.tetcoshvili.api.dto.TacticDTO;
import std.tetcoshvili.api.entity.Tactics;

import java.util.List;

@Mapper(componentModel = "spring", uses = TacticCardMapper.class)

public interface TacticMapper {

    @Mapping(source = "tacticId", target = "id")
    @Mapping(source = "tacticCards", target = "tacticCards")
    TacticDTO toDto(Tactics tactics);

    List<TacticDTO> fromTactics(List<Tactics> tactics);

    Tactics toTactic(TacticDTO tacticDTO);
}