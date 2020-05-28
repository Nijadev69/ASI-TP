package com.cpe.springboot.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void createUser() {
        User u = new User(1, "Nico", "test");
        assertTrue(u.getId().intValue() == 1);
        assertTrue(u.getSurname().equals("Nico"));
        assertTrue(u.getPassword().equals("test"));
    }

    @Test
    public void displayUser() {
        User u = new User(1, "Nico", "test");
        String expectedResult = "User{id=1, surname='Nico', password='test'}";
        assertTrue(u.toString().equals(expectedResult));
    }

}
