package base.feignclient.fallback;

import base.feignclient.UserFeignClient;
import org.springframework.stereotype.Component;

// 降级处理
@Component
public class UserFeignClientFallback implements UserFeignClient {
    private String SERVICE_NOT_ACCESS = "service is not access.";

    @Override
    public String login() {
        return SERVICE_NOT_ACCESS;
    }

    @Override
    public String loginSecond() {
        return SERVICE_NOT_ACCESS;
    }
}
