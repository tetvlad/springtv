package std.tetcoshvili.api.dto;

import lombok.Data;
import java.util.List;

@Data
public class HeroAbilitiesDTO {
    private List<String> abilities;  // "antimage_mana_break", "axe_berserkers_call"
}
