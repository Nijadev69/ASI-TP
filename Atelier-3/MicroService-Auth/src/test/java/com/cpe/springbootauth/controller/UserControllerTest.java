package com.cpe.springbootauth.controller;

import com.cpe.springbootauth.model.User;
import com.cpe.springbootauth.user.UserController;
import com.cpe.springbootauth.user.UserService;
import com.cpe.springbootauth.utils.Utils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.security.NoSuchAlgorithmException;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    User mockUser;

    @Before
    public void setUp() throws NoSuchAlgorithmException {
        mockUser = new User("Test0", Utils.hashPassword("pass0"));
    }

    @Test
    public void register() throws Exception {
        Mockito.when(
                userService.addUser(Mockito.any(User.class))
        ).thenReturn(mockUser);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/register").accept(MediaType.APPLICATION_JSON);

    }

}
