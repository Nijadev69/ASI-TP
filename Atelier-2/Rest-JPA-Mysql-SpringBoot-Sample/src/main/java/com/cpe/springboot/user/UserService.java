package com.cpe.springboot.user;

import com.cpe.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public int addUser(User user) {

    }

    public User getUser(int id) {

    }
}
