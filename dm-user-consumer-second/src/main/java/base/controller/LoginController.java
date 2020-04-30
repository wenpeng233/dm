package base.controller;

import base.feignclient.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping(value = "/loginSecond", method = RequestMethod.GET)
    public String loginSecond(){
        return userFeignClient.loginSecond();
    }
}
