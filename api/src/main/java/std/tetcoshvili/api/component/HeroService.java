package std.tetcoshvili.api.component;

import org.springframework.stereotype.Service;
import std.tetcoshvili.api.dao.HeroDAO;
import std.tetcoshvili.api.entity.Hero;
import std.tetcoshvili.api.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class HeroService {

    private final HeroDAO heroDAO;

    public HeroService(HeroDAO heroDAO) {
        this.heroDAO = heroDAO;
    }

    public List<Hero> getAllHeroes() {
        return heroDAO.findAll();
    }

    public Hero getHeroById(Long id) {
        return heroDAO.findById(id).orElseThrow(NotFoundException::new);
    }

    public Hero saveHero(Hero hero) {
        return heroDAO.save(hero);
    }
}