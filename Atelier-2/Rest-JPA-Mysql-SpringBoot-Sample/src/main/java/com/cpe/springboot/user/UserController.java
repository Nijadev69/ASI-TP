package com.cpe.springboot.user;

import com.cpe.springboot.dto.UserDTO;
import com.cpe.springboot.model.Card;
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
     * Utilise un UserDTO afin de ne pas se soucier des champs non renseignés dans le model User
     */
    @RequestMapping(method= RequestMethod.POST,value="/user")
    public ResponseEntity addUser(@RequestBody UserDTO userDTO) throws NoSuchAlgorithmException {
        User user = new User();

        BeanUtils.copyProperties(userDTO, user);
        user.setHashPassword(Utils.hashPassword(userDTO.getPassword()));

        uService.addUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    /*
     * Fonction appelée pour identifier un utilisateur et permettre son authentification
     * Utilise le model LoginForm pour récupérer les paramètres du formulaire
     */
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

    /*
     * Récupère un utilisateur en fonction de son id
     */
    @RequestMapping(method=RequestMethod.GET,value="/user/{id}")
    public User getUserByID(@PathVariable String id) {
        User u=uService.getUserById(Integer.valueOf(id));

        return u;
    }

    /*
     * Récupère les cartes d'un utilisateur
     */
    @RequestMapping(method=RequestMethod.GET,value="/user/{id}/cards")
    public List<Card> getCards(@PathVariable String id) {
        User u=uService.getUserById(Integer.valueOf(id));

        return u.getCards();
    }

}
