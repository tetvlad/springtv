package std.tetcoshvili.api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import std.tetcoshvili.api.service.HeroService;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataBaseInit implements ApplicationRunner {

    @Value("${db.init:true}")
    private Boolean init;

    private final HeroService heroService;

    @Override
    public void run(ApplicationArguments args) {
        if (Boolean.TRUE.equals(init)) {
            log.info("Loading heroes from OpenDota API...");
            try {
                heroService.loadHeroes();
                log.info("Heroes loaded successfully!");
            } catch (Exception e) {
                log.error("Failed to load heroes: {}", e.getMessage());
            }
        } else {
            log.info("Skipping DB init (db.init=false)");
        }
    }
}
