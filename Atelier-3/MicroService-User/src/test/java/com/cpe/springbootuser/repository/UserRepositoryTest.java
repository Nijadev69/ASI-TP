package com.cpe.springbootuser.repository;

import com.cpe.springbootuser.model.User;
import com.cpe.springbootuser.user.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    List<User> users = new ArrayList<>();

    @Before
    public void setUp() {
        System.out.println("[BEFORE TEST] Creating users");
        users.add(new User("Michael"));
        users.add(new User("John"));
        users.add(new User("Michael"));
        for(User u: users) {
            u = userRepository.save(u);
        }
    }

    @After
    public void cleanUp() {
        System.out.println("[AFTER TEST] Deleting users");
        for(User u: users)
            userRepository.delete(u);
    }

    @Test
    public void saveUser() {
        System.out.println("[TEST] Saving users");
        User u = new User("Rick");
        userRepository.save(u);
        assertTrue(true);
    }

    @Test
    public void getUser() {
        List<User> usersTest = userRepository.findByNameIgnoreCase("Michael");
        for(User u : usersTest){
            assertTrue(u.getName().equals("Michael"));
            assertTrue(u.getMoney().equals(5000));
            String expectedU1ToString = "User{name='Michael', money='5000'}";
            assertEquals(u.toString(), expectedU1ToString);
        }
    }
}
