package com.cpe.springboot.service;

import com.cpe.springboot.card.CardRepository;
import com.cpe.springboot.card.CardService;
import com.cpe.springboot.model.Card;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CardService.class)
public class CardServiceTest {
    @Autowired
    private CardService cService;

    @MockBean
    private CardRepository cRepo;

    List<Card> tmpListCard = new ArrayList<>();
    Card tmpCard = new Card(1, "SpiderMan", "Homme araignée", "MARVEL", 100, 80, 75, 60, "https://icon-library.net/images/spiderman-icon/spiderman-icon-15.jpg", false, 1);
    Card tmpCard2 = new Card(2, "Thor", "Dieu d'Asgard", "MARVEL", 100, 80, 75, 60, "https://icon-library.net/images/spiderman-icon/spiderman-icon-15.jpg", false, 1);


    @Before
    public void setUp() {
        System.out.println("[BEFORE TEST] Creating cards");
        tmpListCard.add(tmpCard);
        tmpListCard.add(tmpCard2);
    }

    @Test
    public void getCard() {
        Mockito.when(
                cRepo.findByName(Mockito.any())
        ).thenReturn(Optional.ofNullable(tmpCard));
        Card cardInfo=cService.getCardByName("Thor");
        assertTrue(cardInfo.toString().equals(tmpCard.toString()));

        Mockito.when(
                cRepo.findById(Mockito.anyInt())
        ).thenReturn(Optional.ofNullable(tmpCard));
        assertTrue(cardInfo.toString().equals(tmpCard.toString()));
    }

    @Test
    public void getCards() {
        Mockito.when(
                cRepo.findByUserId(Mockito.anyInt())
        ).thenReturn(tmpListCard);
        List<Card> cardList = cService.getCardsByUserId(2);
        assertFalse(CollectionUtils.isEmpty(cardList));
    }

    @Test
    public void updateCard() {
        Mockito.when(
                cRepo.save(Mockito.any(Card.class))
        ).thenReturn(tmpCard);
        Card cardInfo=cService.updateCard(tmpCard2);
        assertTrue(cardInfo.toString().equals(tmpCard.toString()));
    }

}
