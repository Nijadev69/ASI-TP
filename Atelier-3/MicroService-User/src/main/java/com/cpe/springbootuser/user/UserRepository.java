package com.cpe.springbootuser.user;

import com.cpe.springbootuser.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByNameIgnoreCase(String name);
}
