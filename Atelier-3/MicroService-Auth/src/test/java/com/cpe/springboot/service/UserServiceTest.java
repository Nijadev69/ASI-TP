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

import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserService.class)
public class UserServiceTest {

    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;

    User user;

    @Before
    public void setUp() {
        user = new User(100,"Test0", "pass0");
    }

    @After
    public void cleanUp() {
        user = null;
    }

    @Test
    public void getUser() {
        Mockito.when(
                userRepository.findBySurname(Mockito.anyString())
        ).thenReturn(Optional.ofNullable(user));
        User userInfos = userService.getUserBySurname("Test1");
        assertTrue(userInfos.toString().equals(user.toString()));

        Mockito.when(
                userRepository.findById(Mockito.anyInt())
        ).thenReturn(Optional.ofNullable(user));
        userInfos = userService.getUserById(1);
        assertTrue(userInfos.toString().equals(user.toString()));
    }

    @Test
    public void addUser() {
        Mockito.when(
                userRepository.save(Mockito.any(User.class))
        ).thenReturn(user);
        User userInfos = userService.addUser(new User("Test1", "pass1"));
        assertTrue(userInfos.toString().equals(user.toString()));
    }

}
