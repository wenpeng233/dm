package base.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "用户登录成功！";
    }

    @RequestMapping(value = "/loginSecond", method = RequestMethod.GET)
    public String loginSecond() {
        return "用户登录成功Second！";
    }
}
