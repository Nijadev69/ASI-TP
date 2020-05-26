package com.cpe.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @Column(unique = true)
    private String surname;
    private String password;

    public User() {
    }

    public User(int id, String name, String surname, String password) {
        super();
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }


}