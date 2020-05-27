package com.cpe.springboot.model;

import javax.persistence.*;

@Entity
public class Card {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @Lob
    private String description;
    private String family;
    private int hp;
    private int energy;
    private int attack;
    private int defence;
    private String imgUrl;
    private boolean onSale = true;
    private int userId;

    public Card() {

    }

    public Card(int id, String name, String description, String family, int hp, int energy, int attack, int defence, String imgUrl, boolean onSale, int userId) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.family = family;
        this.hp = hp;
        this.energy = energy;
        this.attack = attack;
        this.defence = defence;
        this.imgUrl = imgUrl;
        this.onSale = onSale;
        this.userId = userId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", family='" + family + '\'' +
                ", hp=" + hp +
                ", energy=" + energy +
                ", attack=" + attack +
                ", defence=" + defence +
                ", imgUrl='" + imgUrl + '\'' +
                ", onSale=" + onSale +
                ", userId=" + userId +
                '}';
    }
}
