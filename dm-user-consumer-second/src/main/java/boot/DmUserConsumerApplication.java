package boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
// 给出FeiginClient的包位置，否则无法扫到FeiginClient生成对应的bean
@EnableFeignClients({"base.feignclient"})
@ComponentScan(basePackages = {"base"})
public class DmUserConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DmUserConsumerApplication.class, args);
    }
}
