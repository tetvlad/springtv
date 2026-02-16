package std.tetcoshvili.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import std.tetcoshvili.api.dto.AbilityDTO;
import std.tetcoshvili.api.dto.OpenDotaHeroDTO;
import std.tetcoshvili.api.dto.HeroAbilitiesDTO;
import java.util.Map;

    @FeignClient(value = "openDota", url = "https://api.opendota.com/api/")
    public interface OpenDotaApiClient {
        @RequestMapping(method = RequestMethod.GET, value = "/constants/heroes", produces = "application/json")
        Map<Integer, OpenDotaHeroDTO> getHeroes();

        @RequestMapping(method = RequestMethod.GET, value = "/constants/hero_abilities", produces = "application/json")
        Map<String, HeroAbilitiesDTO> getHeroAbilities();

        @RequestMapping(method = RequestMethod.GET, value = "/constants/abilities", produces = "application/json")
        Map<String, AbilityDTO> getAbilities();


    }


