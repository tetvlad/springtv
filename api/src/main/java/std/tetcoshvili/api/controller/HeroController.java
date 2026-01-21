package std.tetcoshvili.api.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import std.tetcoshvili.api.component.HeroService;
import std.tetcoshvili.api.entity.Hero;

import java.util.List;

@RestController
@RequestMapping("/api/hero")
public class HeroController {

    private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping
    public List<Hero> getAllHeroes() {
        return heroService.getAllHeroes();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Hero getHeroById(@PathVariable Long id) {
        return heroService.getHeroById(id);
                //.orElseThrow(() -> new RuntimeException("Hero not found"));
    }

    @PostMapping
    public Hero createHero(@RequestBody Hero hero) {
        return heroService.saveHero(hero);
    }

}