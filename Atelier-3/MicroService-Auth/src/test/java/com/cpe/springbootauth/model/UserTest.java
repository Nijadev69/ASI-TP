package com.cpe.springbootauth.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void createUser() {
        System.out.println("[TEST] Creating user");
        User u = new User(1, "Nico", "test");
        assertTrue(u.getId().intValue() == 1);
        assertTrue(u.getSurname().equals("Nico"));
        assertTrue(u.getPassword().equals("test"));
    }

    @Test
    public void displayUser() {
        System.out.println("[TEST] Testing display user");
        User u = new User(1, "Nico", "test");
        String expectedResult = "User{surname='Nico', password='test'}";
        assertTrue(u.toString().equals(expectedResult));
    }

}
