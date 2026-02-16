package std.tetcoshvili.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import std.tetcoshvili.api.entity.TacticCard;

public interface TacticCardDAO extends JpaRepository<TacticCard, Long> {
}
