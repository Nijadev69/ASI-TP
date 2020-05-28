package com.cpe.springboot.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    @Test
    public void createUser() {
        User u = new User(1, "Nico", "test");
    }

    @Test
    public void displayUser() {

    }

}
