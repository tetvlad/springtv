package std.tetcoshvili.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import std.tetcoshvili.api.entity.Hero;

@Repository
public interface HeroDAO extends JpaRepository<Hero, Long> {
}