package com.cpe.springboot.user;

import com.cpe.springboot.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findBySurname(String surname);

    Optional<User> findById(int id);
}
