package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaServer
@ComponentScan("server.*")
public class DmEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DmEurekaServerApplication.class, args);
    }
}
