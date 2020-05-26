package com.cpe.springboot.user;

import com.cpe.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService uService;

    @RequestMapping(method= RequestMethod.POST,value="/user")
    public void addUser(@RequestBody User user) {
        uService.addUser(user);
    }

    @RequestMapping(method= RequestMethod.GET,value="/user")
    public User getUser(@RequestBody String surname, @RequestBody String password) throws Exception {
        User u=uService.getUserBySurname(surname);
        if(u.getPassword().equals(password)){
            throw new Exception("Invalid credentials");
        }
        return u;
    }

    @RequestMapping(method=RequestMethod.GET,value="/user/{id}")
    public User getUserByID(@PathVariable String id) {
        User u=uService.getUserById(Integer.valueOf(id));
        return u;
    }

}
