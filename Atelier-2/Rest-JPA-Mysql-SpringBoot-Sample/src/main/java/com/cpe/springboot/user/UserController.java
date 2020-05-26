package com.cpe.springboot.user;

import com.cpe.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class UserController {
    @Autowired
    UserService uService;

    @RequestMapping(method= RequestMethod.POST,value="/user")
    public void addUser(@RequestBody User user) {
        uService.addUser(user);
    }

    @RequestMapping(method=RequestMethod.GET,value="/user/{id}")
    public User getUser(@PathVariable String id) {
        User u=uService.getUserById(Integer.valueOf(id));
        return u;
    }

}
