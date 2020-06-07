package com.cpe.springboot.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CardTest {

    @Before
    public void setUp() {
        System.out.println("[BEFORE TEST] -- Add Card to test");
    }

    @After
    public void tearDown() {
        System.out.println("[AFTER TEST] -- CLEAN Card list");
    }

    @Test
    public void createCard() {
        Card c = new Card(1, "SpiderMan", "Homme araignée", "MARVEL", 100, 80, 75, 60, "https://icon-library.net/images/spiderman-icon/spiderman-icon-15.jpg", false, 1);
        assertTrue(c.getId().intValue() == 1);
        assertTrue(c.getName() == "SpiderMan");
        assertTrue(c.getDescription() == "Homme araignée");
        assertTrue(c.getFamily() == "MARVEL");
        assertTrue(c.getHp() == 100);
        assertTrue(c.getEnergy() == 80);
        assertTrue(c.getAttack() == 75);
        assertTrue(c.getDefence() == 60);
        assertTrue(c.getImgUrl() == "https://icon-library.net/images/spiderman-icon/spiderman-icon-15.jpg");
        assertTrue(c.getOnSale() == false);
        assertTrue(c.getUserId() == 1);
    }

    @Test
    public void displayHero() {
        Card c = new Card(1, "SpiderMan", "Homme araignée", "MARVEL", 100, 80, 75, 60, "https://icon-library.net/images/spiderman-icon/spiderman-icon-15.jpg", false, 1);
        String expectedResult="Card{id=1, name='SpiderMan', description='Homme araignée', family='MARVEL', hp=100, energy=80, attack=75, defence=60, imgUrl='https://icon-library.net/images/spiderman-icon/spiderman-icon-15.jpg', onSale=false, userId=1}";
        assertTrue(c.toString().equals(expectedResult));
    }

}
