package std.tetcoshvili.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class Spring_tvApplication {
    private static final Logger log = Logger.getLogger(Spring_tvApplication.class.getName());

    public static void main(String[] args) {

        SpringApplication.run(Spring_tvApplication.class, args);

        //ConfigurableApplicationContext run = SpringApplication.run(Spring_tvApplication.class, args);
        //String[] beanDefinitionNames = run.getBeanDefinitionNames();
        //System.out.println(Arrays.toString(beanDefinitionNames));
        //System.out.println(beanDefinitionNames.length);


        //String[] beanDefinitionNames = run.getBeanDefinitionNames();

        //log.info(Arrays.toString(beanDefinitionNames));
        //log.info(String.valueOf(beanDefinitionNames.length));

        //Hero hero = (Hero) run.getBean("hero");
        //Hero hero2 = (Hero) run.getBean("hero");
        //log.info(hero.toString());
        //log.info(hero2.toString());
    }

}


