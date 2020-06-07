package com.cpe.springboot.service;

import com.cpe.springboot.model.User;
import com.cpe.springboot.user.UserRepository;
import com.cpe.springboot.user.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserService.class)
public class UserServiceTest {

    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;

    List<User> users;

    User user;

    @Before
    public void setUp() {
        users = new ArrayList<>();
        users.add(new User("John"));
        users.add(new User("Michael"));
        users.add(new User("John"));
        users.add(new User("Rick"));
        users.add(new User("Michael"));

        user = new User("Michael");
    }

    @After
    public void cleanUp() {
        users.clear();
    }

    @Test
    public void getUsers() {
        Mockito.when(
                userRepository.findByNameIgnoreCase(Mockito.matches("Michael"))
        ).thenReturn(users.stream().filter(user1 -> "Michael".equals(user1.getName())).collect(Collectors.toList()));
        List<User> usersTest = userService.getUsersByName("Michael");
        assertFalse(usersTest.isEmpty());
        assertEquals(2, usersTest.size());
    }

    @Test
    public void addUser() {
        Mockito.when(
                userRepository.save(Mockito.any(User.class))
        ).thenReturn(user);
        User userTest = userService.addUser(new User("Michael"));
        assertEquals(user.toString(), userTest.toString());
    }

}
