package com.cpe.springboot.user;

import com.cpe.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    /*
     * Enregistre un nouvel utilisateur
     */
    public User addUser(User user) {
        User addedUser = userRepository.save(user);

        return addedUser;
    }

    /*
     * Récupère un utilisateur par son id
     */
    public User getUserById(int id) {
            return userRepository.findOne(id);
    }

    /*
     * Récupère une liste des utilisateurs par leurs noms
     */
    public List<User> getUsersByName(String name) {
        Assert.notNull(name, "Le nom ne peut pas être null.");
        List<User> users = userRepository.findByNameIgnoreCase(name);
        if (!CollectionUtils.isEmpty(users)) {
            return users;
        } else {
            return null;
        }
    }

    //Modifie un utilisateur dans la BD
    public User updateUser(User u) {
        User user = userRepository.save(u);

        return user;
    }
}
