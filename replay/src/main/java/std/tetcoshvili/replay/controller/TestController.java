package std.tetcoshvili.replay.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import std.tetcoshvili.replay.client.ApiClient;
import std.tetcoshvili.replay.client.Hero;

@RestController
@RequestMapping("/replay")
public class TestController {

    private final ApiClient apiClient;
    public TestController(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    @GetMapping
    public String getReplay(@AuthenticationPrincipal Jwt jwt ) {
        //Hero hero = apiClient.getHero(1L);


        return "Hello EPRST!" + jwt.getClaim("name");


    }
}
