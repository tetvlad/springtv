package std.tetcoshvili.api.dto;

import lombok.Data;
import java.util.List;

@Data
public class TacticDTO {

    private Long id;
    private String name;
    private String description;

    private List<TacticCardDTO> tacticCards;
}