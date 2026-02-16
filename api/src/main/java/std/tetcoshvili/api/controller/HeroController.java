package std.tetcoshvili.api.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import std.tetcoshvili.api.client.OpenDotaApiClient;
import std.tetcoshvili.api.dto.OpenDotaHeroDTO;
import std.tetcoshvili.api.service.HeroService;
import std.tetcoshvili.api.dto.HeroAbilitiesDTO;
import std.tetcoshvili.api.entity.Hero;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/hero")
public class HeroController {

    private final HeroService heroService;
    private final OpenDotaApiClient openDotaApiClient;

    public HeroController(HeroService heroService, OpenDotaApiClient openDotaApiClient) {
        this.heroService = heroService;
        this.openDotaApiClient = openDotaApiClient;
    }

    @GetMapping
    public List<Hero> getAllHeroes() {
        return heroService.getAllHeroes();
    }

    @GetMapping("/open-dota")
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public Map<Integer, OpenDotaHeroDTO> getOpenDotaHero() {
        return openDotaApiClient.getHeroes();
    }

    @PostMapping
    public Hero createHero(@RequestBody Hero hero) {
        return heroService.saveHero(hero);
    }

    @GetMapping("/skills")
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public Map<String, HeroAbilitiesDTO> getSkills() {
        return openDotaApiClient.getHeroAbilities();
    }

    @PostMapping("/load-heroes")
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public String loadHeroesToDB() {
        heroService.loadHeroes();
        return "Heroes loaded to DB!";
    }

    @PostMapping("/load-abilities")
    //@PreAuthorize("permitAll()")  //
    public String loadAbilitiesToDB() {
        heroService.loadAbilities();
        return "Abilities loaded to DB!";
    }

    @PostMapping("/load-skills")
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    public String loadSkillsToDB() {
        heroService.loadAndSaveSkills();
        return "Skills saved to DB!";
    }

}