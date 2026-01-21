package std.tetcoshvili.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import std.tetcoshvili.api.entity.Tactics;

public interface TacticDAO extends JpaRepository<Tactics, Long> {
}
