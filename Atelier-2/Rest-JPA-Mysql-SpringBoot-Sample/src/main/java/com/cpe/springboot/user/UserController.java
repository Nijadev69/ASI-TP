package com.cpe.springboot.user;

import com.cpe.springboot.model.JsonResponse;
import com.cpe.springboot.model.LoginForm;
import com.cpe.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

@RestController
public class UserController {
    @Autowired
    UserService uService;

    @RequestMapping(method= RequestMethod.POST, value="/user")
    public void addUser(@RequestBody User user) {
        uService.addUser(user);
    }

    @RequestMapping(method= RequestMethod.POST, value="/user/connect")
    public JsonResponse getUser(@RequestBody LoginForm loginForm) {
        User u=uService.getUserBySurname(loginForm.getSurname());

        /*
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashPassword = digest.digest(loginForm.getPassword().getBytes(StandardCharsets.UTF_8));
        */

        JsonResponse res;
        if(u.getPassword().equals(loginForm.getPassword())){
            res = new JsonResponse(false, "Authentication succeed");
            res.addData("userId", u.getId());
            res.addData("surname", u.getSurname());
        } else {
            res = new JsonResponse(true, "Authentication failed");
        }

        return res;
    }

    @RequestMapping(method=RequestMethod.GET,value="/user/{id}")
    public User getUserByID(@PathVariable String id) {
        User u=uService.getUserById(Integer.valueOf(id));

        return u;
    }

}
