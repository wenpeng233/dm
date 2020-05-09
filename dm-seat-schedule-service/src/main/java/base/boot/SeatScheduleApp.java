package base.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableCaching
@EnableFeignClients({"base.feignclient"})
@ComponentScan(basePackages = "base")
public class SeatScheduleApp {

    public static void main(String[] args) {
        SpringApplication.run(SeatScheduleApp.class, args);
    }
}
