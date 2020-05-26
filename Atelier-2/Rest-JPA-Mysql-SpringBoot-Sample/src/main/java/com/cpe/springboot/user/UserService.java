package com.cpe.springboot.user;

import com.cpe.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        User addedUser = userRepository.save(user);
        return addedUser;
    }

    public User getUserById(int id) {
        User user = userRepository.findById(id);
        return user;
    }

    public User getUserBySurname(String surname) {
        User user = userRepository.findBySurname(surname);
        return user;
    }
}
