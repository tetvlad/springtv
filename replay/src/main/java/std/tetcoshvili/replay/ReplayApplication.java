package std.tetcoshvili.replay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
public class ReplayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReplayApplication.class, args);
    }

}
