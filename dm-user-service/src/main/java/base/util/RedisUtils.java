package base.util;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;

public class RedisUtils {

    private static RedisUtils redisUtils;



    @Value("${spring.redis.host}")
    private static String redisHost;

    private RedisUtils(){}


    public static RedissonClient create(){
        Config config = new Config();
        config.useSingleServer()
                .setAddress(redisHost);

        return Redisson.create(config);
    }
}
