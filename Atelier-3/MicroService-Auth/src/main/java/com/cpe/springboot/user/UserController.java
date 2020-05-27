package com.cpe.springboot.user;

import com.cpe.springboot.dto.UserDTO;
import com.cpe.springboot.model.JsonResponse;
import com.cpe.springboot.model.LoginForm;
import com.cpe.springboot.model.User;
import com.cpe.springboot.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.security.NoSuchAlgorithmException;

@RestController
public class UserController {
    @Autowired
    UserService uService;

    /*
     * Fonction permettant d'enregistrer un nouvel utilisateur en base de données
     * Utilise un UserDTO afin de ne pas se soucier des champs non renseignés dans le model User
     */
    @RequestMapping(method= RequestMethod.POST,value="/register")
    public ResponseEntity addUser(@RequestBody UserDTO userDTO) throws Exception {
        ResponseEntity resp;
        User user = new User();

        if(userDTO.getSurname().length() >= 3 && userDTO.getPassword().length() >= 3 && userDTO.getName().length() >= 3) {
            BeanUtils.copyProperties(userDTO, user);
            user.setHashPassword(Utils.hashPassword(userDTO.getPassword()));

            uService.addUser(user);
            /*
            final String uri = "http://localhost:8081/add";

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> request = new HttpEntity(userDTO.toString(), headers);
            URI locationHeader = restTemplate.postForLocation(new URI(uri), request);
            */
            resp = new ResponseEntity(HttpStatus.OK);
        } else {
            resp = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return resp;
    }

    /*
     * Fonction appelée pour identifier un utilisateur et permettre son authentification
     * Utilise le model LoginForm pour récupérer les paramètres du formulaire
     */
    @RequestMapping(method= RequestMethod.POST, value="/connect")
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

}
