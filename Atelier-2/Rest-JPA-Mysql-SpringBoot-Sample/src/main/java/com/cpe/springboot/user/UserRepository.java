package com.cpe.springboot.user;

import com.cpe.springboot.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findBySurname(String surname);
    User findById(int id);
}
