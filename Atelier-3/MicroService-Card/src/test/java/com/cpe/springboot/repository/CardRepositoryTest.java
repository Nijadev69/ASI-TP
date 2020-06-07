package com.cpe.springboot.repository;

import com.cpe.springboot.model.Card;
import com.cpe.springboot.card.CardRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@RunWith(SpringRunner.class)
@DataJpaTest
public class CardRepositoryTest {

    @Autowired
    CardRepository cardRepository;

    List<Card> cards = new ArrayList<>();

    @Before
    public void setUp() {
        System.out.println("[BEFORE TEST] Creating cards");
        cards.add(new Card(1, "SpiderMan", "Homme araignée", "MARVEL", 100, 80, 75, 60, "https://icon-library.net/images/spiderman-icon/spiderman-icon-15.jpg", false, 1));
        cards.add(new Card(2, "Thor", "Dieu d'Asgard", "MARVEL", 100, 80, 75, 60, "https://icon-library.net/images/spiderman-icon/spiderman-icon-15.jpg", false, 1));
        for(Card c: cards) {
            c = cardRepository.save(c);
        }
    }

    @After
    public void cleanUp() {
        System.out.println("[AFTER TEST] Deleting cards");
        //for(Card c: cards)
            cardRepository.deleteAll();
    }

    @Test
    public void saveCard() {
        System.out.println("[TEST] Saving cards");
        Card c = new Card(3, "IronMan", "Tony Stark", "MARVEL", 100, 80, 75, 60, "https://icon-library.net/images/spiderman-icon/spiderman-icon-15.jpg", false, 1);
        cardRepository.save(c);
        assertTrue(true);
    }

    @Test
    public void getCard() {
        Card c1 = cardRepository.findByName("Thor").get();
        assertTrue(c1.getName().equals("Thor"));
        assertTrue(c1.getDescription().equals("Dieu d'Asgard"));
        assertTrue(c1.getFamily().equals("MARVEL"));
        assertTrue(c1.getHp() == 100);
        assertTrue(c1.getEnergy() == 80);
        assertTrue(c1.getAttack() == 75);
        assertTrue(c1.getDefence() == 60);
        assertTrue(c1.getImgUrl().equals("https://icon-library.net/images/spiderman-icon/spiderman-icon-15.jpg"));
        assertTrue(c1.getOnSale() == false);
        assertTrue(c1.getUserId() == 1);


        String expectedC1ToString="Card{id=2, name='Thor', description='Dieu d'Asgard', family='MARVEL', hp=100, energy=80, attack=75, defence=60, imgUrl='https://icon-library.net/images/spiderman-icon/spiderman-icon-15.jpg', onSale=false, userId=1}";
        assertTrue(c1.toString().equals(expectedC1ToString));
    }

}

