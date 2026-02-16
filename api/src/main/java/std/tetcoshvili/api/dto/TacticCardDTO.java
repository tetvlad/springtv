package std.tetcoshvili.api.dto;

import lombok.Data;
import std.tetcoshvili.api.entity.TacticCard;

@Data
public class TacticCardDTO {

    private Long id;
    private Long heroId;
    private Long playerInfoId;
    private Long tacticsId;
//    public static TacticCardDTO from(TacticCard entity) {
//        TacticCardDTO dto = new TacticCardDTO();
//        dto.setId(entity.getId());
//        dto.setHeroId(entity.getHero().getId());
//        dto.setPlayerInfoId(entity.getPlayerInfo().getPlayerId());
//        dto.setTacticsId(entity.getTactics().getTacticId());
//        return dto;
//    }
}
