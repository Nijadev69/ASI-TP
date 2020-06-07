package com.cpe.springbootuser.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void createUser() {
        System.out.println("[TEST] Creating user");
        User u = new User("customName");
        assertTrue(u.getName().equals("customName"));
        assertTrue(u.getMoney().equals(5000));
    }

    @Test
    public void displayUser() {
        System.out.println("[TEST] Testing display user");
        User u = new User("customName");
        String expectedResult = "User{name='customName', money='5000'}";
        assertEquals(u.toString(), expectedResult);
    }

}
