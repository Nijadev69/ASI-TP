package com.cpe.springbootuser.user;

import com.cpe.springbootuser.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService uService;

    /*
     * Fonction permettant d'enregistrer un nouvel utilisateur en base de données
     */
    @RequestMapping(method= RequestMethod.POST,value="/add")
    public ResponseEntity addUser(@RequestBody User user) {
        uService.addUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }


    /*
     * Récupère un utilisateur en fonction de son id
     */
    @RequestMapping(method=RequestMethod.GET,value="/{id}")
    public User getUserByID(@PathVariable String id) {
        User u=uService.getUserById(Integer.valueOf(id));

        return u;
    }

    /*
     * update l'argent de l'utilisateur acheteur
     */

    @RequestMapping(method=RequestMethod.POST,value="/setMoneyBuy/{userId}/{price}")
    public ResponseEntity setMoneyBuy(@PathVariable int userId, @PathVariable int price) {
        User u = uService.getUserById(userId);

        u.setMoney(u.getMoney()-price);
        uService.updateUser(u);

        return new ResponseEntity(HttpStatus.OK);
    }

    /*
     * update l'argent de l'utilisateur vendeur
     */

    @RequestMapping(method=RequestMethod.POST,value="/setMoneySell/{userId}/{price}")
    public ResponseEntity setMoneySell(@PathVariable int userId, @PathVariable int price) {
        User u = uService.getUserById(userId);

        u.setMoney(u.getMoney()+price);
        uService.updateUser(u);

        return new ResponseEntity(HttpStatus.OK);
    }

}
