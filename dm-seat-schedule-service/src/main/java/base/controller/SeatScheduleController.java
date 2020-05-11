package base.controller;

import base.entity.User;
import base.feignclient.UserServiceFeignClient;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;


@RestController
public class SeatScheduleController {

    @Bean
    public static RedissonClient redissonClient(){
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://192.168.137.138:6379");
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }

    @Autowired
    private RedissonClient redisson;

    @Autowired
    private UserServiceFeignClient userServiceFeignClient;

    public SeatScheduleController() throws IOException {
    }



    @RequestMapping(value = "/bookSeat", method = RequestMethod.GET)
    public String bookSeat(String seatId, String userId){
        RLock lock = redisson.getLock(seatId);

        if(lock.isLocked()){
            System.out.println("已经上锁了：" + lock.getName());
        }

        lock.lock();
        try {
            System.out.println("成功预定座位：" + seatId);
            Thread.sleep(300);
            System.out.println("成功创建订单：" + seatId + userId);
            Thread.sleep(300);

            User userObj = userServiceFeignClient.getUser(userId);

            if (userObj == null) {
                throw new Exception("user is not exist.");
            }

            System.out.println("成功将订单" + seatId + userId + "和用户" + userId + "关联");
            Thread.sleep(1000);
            lock.unlock();

        } catch (Exception e){
            System.out.println("roll back");
        } finally {
            if (lock != null){
                lock.unlock();
            }
        }
        return seatId;
    }
}
