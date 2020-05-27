package com.cpe.springboot.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @Column(unique = true)
    private String surname;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Card> cards;

    public User() {
    }

    public User(int id, String name, String surname, String password) {
        super();
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", cards=" + cards +
                '}';
    }
}