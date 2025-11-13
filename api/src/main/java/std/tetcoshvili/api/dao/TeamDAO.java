package std.tetcoshvili.api.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import std.tetcoshvili.api.entity.Team;
import java.util.UUID;

public interface TeamDAO extends JpaRepository<Team, UUID> {
}