package base.util;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class RedisUtils {

    private static RedisUtils redisUtils;

    private RedisUtils(){}


    public static RedissonClient redissonClient(){
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://192.168.137.138:6379");
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }
}
