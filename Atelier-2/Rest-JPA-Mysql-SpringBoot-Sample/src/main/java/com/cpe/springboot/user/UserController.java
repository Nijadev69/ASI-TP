package com.cpe.springboot.user;

import com.cpe.springboot.dto.UserDTO;
import com.cpe.springboot.model.JsonResponse;
import com.cpe.springboot.model.LoginForm;
import com.cpe.springboot.model.User;
import com.cpe.springboot.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.NoSuchAlgorithmException;

@RestController
public class UserController {
    @Autowired
    UserService uService;

    @RequestMapping(method= RequestMethod.POST,value="/user")
    public ResponseEntity addUser(@RequestBody UserDTO userDTO) throws NoSuchAlgorithmException {
        User user = new User();

        BeanUtils.copyProperties(userDTO, user);
        user.setHashPassword(Utils.hashPassword(userDTO.getPassword()));

        uService.addUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method= RequestMethod.POST, value="/user/connect")
    public JsonResponse getUser(@RequestBody LoginForm loginForm) throws NoSuchAlgorithmException {
        User u=uService.getUserBySurname(loginForm.getSurname());
        JsonResponse res;

        if(u.getHashPassword().equals(Utils.hashPassword(loginForm.getPassword()))){
            res = new JsonResponse(false, "Authentication succeed");
            res.addData("userId", u.getId());
            res.addData("surname", u.getSurname());
        } else {
            res = new JsonResponse(true, "Authentication failed");
        }

        return res;
    }

    @RequestMapping(method= RequestMethod.GET,value="/user")
    public User getUser(@RequestBody String surname, @RequestBody String password) throws Exception {
        User u = uService.getUserBySurname(surname);
        if (u.getHashPassword().equals(password)) {
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
