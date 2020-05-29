package com.cpe.springboot.service;

import com.cpe.springboot.model.User;
import com.cpe.springboot.user.UserRepository;
import com.cpe.springboot.user.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@RunWith(SpringRunner.class)
@WebMvcTest(value = UserService.class)
public class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @MockBean
    UserService userService;

    User user;

    @Before
    public void setUp() {
        user = new User(100, "Test0", "pass0");
    }

    @Test
    public void getUser() {
        Mockito.when(
                userRepository.findById(Mockito.any())
        ).thenReturn(Optional.ofNullable(user));
        User userInfos = userService.getUserById(1);
        assertTrue(userInfos.toString().equals(user.toString()));

        Mockito.when(
                userRepository.findBySurname(Mockito.any())
        ).thenReturn(Optional.ofNullable(user));
        userInfos = userService.getUserBySurname("Test0");
        assertTrue(userInfos.toString().equals(user.toString()));
    }

    @Test
    public void addUser() {

    }

}
