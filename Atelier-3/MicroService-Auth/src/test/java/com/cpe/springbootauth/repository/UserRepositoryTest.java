package com.cpe.springbootauth.repository;

import com.cpe.springbootauth.model.User;
import com.cpe.springbootauth.user.UserRepository;
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
        users.add(new User("Test0", "pass0"));
        users.add(new User("Test1", "pass1"));
        users.add(new User("Test2", "pass2"));
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
        User u = new User("Test3", "pass3");
        userRepository.save(u);
        assertTrue(true);
    }

    @Test
    public void getUser() {
        System.out.println("[TEST] Getting user with surname 'Test1'");

        User u1 = userRepository.findBySurname("Test1").get();
        assertTrue(u1.getSurname().equals("Test1"));
        assertTrue(u1.getPassword().equals("pass1"));
        String expectedU1ToString = "User{surname='Test1', password='pass1'}";
        assertTrue(u1.toString().equals(expectedU1ToString));
    }

}
