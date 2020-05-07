package base.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "base")
public class RabbitmqDemoBoot {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqDemoBoot.class, args);
    }
}
