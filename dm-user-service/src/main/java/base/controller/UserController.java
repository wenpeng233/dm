package base.controller;

import base.dao.UserDao;
import base.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    public User getUser(@RequestParam("userId") String userId){
        return userDao.getUser(userId);
    }
}
