package std.tetcoshvili.api.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import std.tetcoshvili.api.dao.HeroDAO;
import std.tetcoshvili.api.dao.SkillDAO;
import std.tetcoshvili.api.dto.AbilityDTO;
import std.tetcoshvili.api.dto.HeroAbilitiesDTO;
import std.tetcoshvili.api.dto.OpenDotaHeroDTO;
import std.tetcoshvili.api.entity.Hero;
import std.tetcoshvili.api.client.OpenDotaApiClient;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class HeroService {
    private final HeroDAO heroDAO;
    private final SkillDAO skillDAO;
    private final OpenDotaApiClient openDotaApiClient;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public HeroService(HeroDAO heroDAO, SkillDAO skillDAO, OpenDotaApiClient openDotaApiClient) {
        this.heroDAO = heroDAO;
        this.skillDAO = skillDAO;
        this.openDotaApiClient = openDotaApiClient;
    }

    public List<Hero> getAllHeroes() {
        return heroDAO.findAll();
    }

    public Hero saveHero(Hero hero) {
        return heroDAO.save(hero);
    }

    @Transactional
    public void loadHeroes() {
        Map<Integer, OpenDotaHeroDTO> heroesData = openDotaApiClient.getHeroes();

        for (OpenDotaHeroDTO apiHero : heroesData.values()) {
            String heroName = apiHero.getName().replace("npc_dota_hero_", "");

            jdbcTemplate.update(
                    "INSERT IGNORE INTO hero (name, attack_type, base_health, base_defense, mobility) VALUES (?, ?, ?, ?, ?)",
                    heroName,
                    apiHero.getAttack_type(),
                    apiHero.getBase_health(),
                    apiHero.getBase_armor(),
                    apiHero.getMove_speed()
            );
        }
    }

    @Transactional
    public void loadAndSaveSkills() {
        Map<String, HeroAbilitiesDTO> abilitiesMap = openDotaApiClient.getHeroAbilities();

        for (Map.Entry<String, HeroAbilitiesDTO> entry : abilitiesMap.entrySet()) {
            String heroKey = entry.getKey();  // "npc_dota_hero_axe"
            HeroAbilitiesDTO abilities = entry.getValue();


            String heroName = heroKey.replace("npc_dota_hero_", "");
            Optional<Hero> heroOpt = heroDAO.findByName(heroName);
            if (heroOpt.isEmpty()) {
                System.out.println("Hero not find" + heroName);
            } else {
                Hero hero = heroOpt.get();
                //skillDAO.deleteByHeroId(hero.getId());  // очищаем старые


                for (String skillName : abilities.getAbilities()) {
                    if (!skillName.startsWith("special_bonus") && !skillName.contains("facet")) {
                        jdbcTemplate.update(
                                "INSERT IGNORE INTO skill (hero_id, name, description) VALUES (?, ?, NULL)",
                                hero.getId(), skillName
                        );
                    }
                }
            }
        }
    }

    @Transactional
    public void loadAbilities() {
        Map<String, AbilityDTO> abilitiesData = openDotaApiClient.getAbilities();

        for (Map.Entry<String, AbilityDTO> entry : abilitiesData.entrySet()) {
            jdbcTemplate.update(
                    "INSERT IGNORE INTO ability (name, dname, attrib, behavior, description, img, target_team) VALUES (?, ?, ?, ?, ?, ?, ?)",
                    entry.getKey(),
                    entry.getValue().getDname(),
                    entry.getValue().getAttrib(),
                    entry.getValue().getBehavior(),
                    entry.getValue().getDesc(),
                    entry.getValue().getImg(),
                    entry.getValue().getTarget_team()
            );
        }
    }

}
