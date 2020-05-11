package base.feignclient;

import base.entity.User;
import base.feignclient.fallback.UserServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "dm-user-service"/* , fallback = UserServiceFallback.class */)
public interface UserServiceFeignClient {

    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    public User getUser(@RequestParam("userId") String userId);
}
