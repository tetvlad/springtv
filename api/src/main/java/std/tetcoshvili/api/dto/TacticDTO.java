package std.tetcoshvili.api.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.List;

@Data
public class TacticDTO {

    private Long id;
    @NotEmpty(message = "Не ПУСТОЕ")
    @Size(min = 2, max = 15, message = "размер от {min} до {max}")
    private String name;
    private String description;

    private List<TacticCardDTO> tacticCards;
}