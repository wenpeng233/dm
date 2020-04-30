package base.feignclient;

import base.feignclient.fallback.UserFeignClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "dm-user-provider", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login();

    @RequestMapping(value = "/loginSecond", method = RequestMethod.GET)
    public String loginSecond();
}
