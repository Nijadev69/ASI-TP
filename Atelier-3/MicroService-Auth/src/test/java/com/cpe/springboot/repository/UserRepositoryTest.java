package com.cpe.springboot.repository;

import com.cpe.springboot.model.User;
import com.cpe.springboot.user.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    List<User> users;

    @Before
    public void setUp() {
        users.add(new User(100, "Test0", "pass0"));
        users.add(new User(101, "Test1", "pass1"));
        users.add(new User(102, "Test2", "pass2"));
    }

    @After
    public void cleanUp() {
        for(User u: users)
            userRepository.delete(u);
    }

    @Test
    public void saveUser() {
        for(User u: users) {
            userRepository.save(u);
            assertTrue(true);
        }
    }

    @Test
    public void getUser() {
        User u0 = userRepository.findById(100).get();
        assertTrue(u0.getId() == 100);
        assertTrue(u0.getSurname().equals("Test0"));
        assertTrue(u0.getPassword().equals("pass0"));
        String expectedU0ToString = "User{id=100, surname='Test0', password='pass0'}";
        assertTrue(u0.toString().equals(expectedU0ToString));

        User u1 = userRepository.findBySurname("Test1").get();
        assertTrue(u1.getId() == 101);
        assertTrue(u1.getSurname().equals("Test1"));
        assertTrue(u1.getPassword().equals("pass1"));
        String expectedU1ToString = "User{id=101, surname='Test1', password='pass1'}";
        assertTrue(u1.toString().equals(expectedU1ToString));
    }

}
