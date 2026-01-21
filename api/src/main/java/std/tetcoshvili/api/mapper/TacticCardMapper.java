package std.tetcoshvili.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import std.tetcoshvili.api.dto.TacticCardDTO;
import std.tetcoshvili.api.entity.TacticCard;

import java.util.List;

@Mapper(componentModel = "spring")

public interface TacticCardMapper {
    @Mapping(target = "heroId" , source = "hero.id")
    @Mapping(target = "playerInfoId", source = "playerInfo.playerId")
    @Mapping(target = "tacticsId", source = "tactics.tacticId")

    TacticCardDTO tacticCardToTacticCardDto(TacticCard tacticCard);

    List<TacticCardDTO> tacticCardsToTacticCardDtos(List<TacticCard> tacticCards);
}
