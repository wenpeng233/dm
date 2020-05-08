package base.controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SeatScheduleController {

    private final RedissonClient redisson = Redisson.create();

    @RequestMapping(value = "/bookSeat", method = RequestMethod.GET)
    public String bookSeat(String seatId, String userId){
        RLock lock = redisson.getLock(seatId);

        if(lock.isLocked()){
            System.out.println("已经上锁了：" + lock.getName());
        }

        lock.lock();
        try {
            System.out.println("成功预定座位：" + seatId);
            Thread.sleep(1000);
            System.out.println("成功创建订单：" + seatId + userId);
            Thread.sleep(1000);
            System.out.println("成功将订单" + seatId + userId + "和用户" + userId + "关联");
            Thread.sleep(1000);
            lock.unlock();

        } catch (Exception e){
            lock.unlock();
        }
        return seatId;
    }
}
