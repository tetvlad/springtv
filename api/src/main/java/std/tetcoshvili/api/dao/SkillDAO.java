package std.tetcoshvili.api.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import std.tetcoshvili.api.entity.Skill;


public interface SkillDAO extends JpaRepository<Skill, Long> {
    void deleteByHeroId(Long heroId);  // очищать старые скиллы
}
