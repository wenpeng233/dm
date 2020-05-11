package base.util;

import org.apache.commons.lang.StringUtils;
import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisUtils {

    private static RedisUtils redisUtils = getInstance();

    @Resource
    private RedisTemplate<String, Object> redisTemplate;



    private RedisUtils() {}

    /**
     * double check 单例
     * @return
     */
    public static RedisUtils getInstance(){
        if (redisUtils == null){
            synchronized (RedisUtils.class){
                if (redisUtils == null) {
                    redisUtils = new RedisUtils();
                }
            }
        }
        return redisUtils;
    }

    public Redisson getRedisson(Config config){
        return (Redisson) Redisson.create(config);
    }

    public boolean set(String key, String value){
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public boolean update(String key, String value){
        boolean result = false;
        try {
            if (redisTemplate != null && !StringUtils.isEmpty(key)){
                redisTemplate.opsForValue().getAndSet(key, value);
            }
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public boolean delete(String key){
        boolean result = false;
        try {
            if (redisTemplate != null && !StringUtils.isEmpty(key)){
                redisTemplate.delete(key);
            }
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
