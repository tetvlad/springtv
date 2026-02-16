package std.tetcoshvili.api.dto;


import lombok.Data;

@Data
public class OpenDotaHeroDTO {
    private String name;
    private String attack_type;
    private Integer base_health;
    private Integer base_armor;
    private Integer move_speed;
}
