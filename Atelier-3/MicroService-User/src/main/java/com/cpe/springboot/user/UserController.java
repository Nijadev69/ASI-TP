package com.cpe.springboot.user;

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
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService uService;

    /*
     * Fonction permettant d'enregistrer un nouvel utilisateur en base de données
     */
    @RequestMapping(method= RequestMethod.POST,value="/add")
    public ResponseEntity addUser(@RequestBody String name) {
        User user = new User(name);
        uService.addUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }


    /*
     * Récupère un utilisateur en fonction de son id
     */
    @RequestMapping(method=RequestMethod.GET,value="/byId/{id}")
    public User getUserByID(@PathVariable String id) {
        User u=uService.getUserById(Integer.valueOf(id));

        return u;
    }

}
