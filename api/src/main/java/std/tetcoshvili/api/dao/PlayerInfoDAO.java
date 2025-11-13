package std.tetcoshvili.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import std.tetcoshvili.api.entity.PlayerInfo;
import java.util.UUID;

public interface PlayerInfoDAO extends JpaRepository<PlayerInfo, UUID> {
}
