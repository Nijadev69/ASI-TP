package com.cpe.springboot.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_credentials")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String surname;
    private String password;

    public User() {
    }

    public User(int id, String surname, String password) {
        super();
        this.id = id;
        this.surname = surname;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getHashPassword() {
        return password;
    }

    public void setHashPassword(String hashPassword) {
        this.password = hashPassword;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", surname='" + surname + "\'" +
                ", password='" + password + "\'" +
                "}";
    }
}