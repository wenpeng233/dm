package base.boot;

import base.filter.PreFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@ComponentScan(basePackages = "base")
public class GatewayZuulApp {

    public static void main(String[] args) {
        SpringApplication.run(GatewayZuulApp.class, args);
    }

    @Bean
    public PreFilter preFilter(){
        return new PreFilter();
    }
}
