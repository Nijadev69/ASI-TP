package com.cpe.springbootuser.model;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer money = 5000;

    public User() {
    }

    public User(String name) {
        super();
        this.name = name;
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

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}