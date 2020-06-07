package com.cpe.springbootauth.user;

import com.cpe.springbootauth.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findBySurname(String surname);
    Optional<User> findById(int id);
}
