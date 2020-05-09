package base.feignclient.fallback;

import base.entity.User;
import base.feignclient.UserServiceFeignClient;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFallback implements UserServiceFeignClient {

    @Override
    public User getUser(java.lang.String userId) {
        return new User();
    }
}
