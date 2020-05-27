package com.cpe.springboot.user;

import com.cpe.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Optional<User> userOpt = userRepository.findById(id);

        if (userOpt.isPresent()) {
            return userOpt.get();
        }else {
            return null;
        }
    }

    /*
     * Réucpère un utilisateur par son surname
     */
    public User getUserBySurname(String surname) {
        Optional<User> userOpt = userRepository.findBySurname(surname);

        if (userOpt.isPresent()) {
            return userOpt.get();
        }else {
            return null;
        }
    }
}
