package com.cpe.springboot.card;

import com.cpe.springboot.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardController {

    @Autowired
    CardService cService;

    //Route d'accès à une carte par son Id
    @RequestMapping(method= RequestMethod.GET,value="/id/{id}")
    public Card getCard(@PathVariable String id) {
        Card c = cService.getCard(Integer.valueOf(id));

        return c;
    }

    //Route d'accès à une carte par son nom
    @RequestMapping(method= RequestMethod.GET,value="/by/{name}")
    public Card getCardByName(@PathVariable String name) {
        Card c = cService.getCardByName(name);

        return c;
    }

    //Route d'accès aux cartes
    @RequestMapping(method= RequestMethod.GET,value="/all")
    public List<Card> getCards() {
        List<Card> lC = cService.getCards();

        return lC;
    }

    //Vend une carte
    @RequestMapping(method= RequestMethod.PATCH,value="/sell/{name}")
    public ResponseEntity sellCards(@PathVariable String name) {
        Card card = cService.getCardByName(name);

        card.setOnSale(true);
        cService.updateCard(card);

        return new ResponseEntity(HttpStatus.OK);
    }

    //Achète une carte
    @RequestMapping(method= RequestMethod.PATCH,value="/buy/{name}/{userId}")
    public ResponseEntity buyCard(@PathVariable String name, @PathVariable int userId) {
        Card c = cService.getCardByName(name);

        c.setOnSale(false);
        c.setUserId(userId);

        cService.updateCard(c);

        return new ResponseEntity(HttpStatus.OK);
    }

    //Route d'accès aux cartes d'un utilisateur
    @RequestMapping(method= RequestMethod.GET,value="/{id}/list")
    public List<Card> getUserCards(@PathVariable int id) {
        List<Card> lC = cService.getCardsByUserId(id);

        return lC;
    }
}
