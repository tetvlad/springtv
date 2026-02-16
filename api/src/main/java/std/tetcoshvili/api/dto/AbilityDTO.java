package std.tetcoshvili.api.dto;

import lombok.Data;
import java.util.List;

@Data
public class AbilityDTO {
    private String dname;        // "" или "Mana Break"
    private List<Object> attrib; // [{"key":"mana_void_aghanim_bonus","value":"75"}]
    private String desc;         // полное описание
    private List<String> behavior; // ["Unit Target","Channeled","Hidden"]
    private String img;          // "/apps/dota2/images/...png"
    private Object target_team;  // "Enemy" | "Both"
    // mc, scepter, shatter, lore — опционально, NULL в БД
}