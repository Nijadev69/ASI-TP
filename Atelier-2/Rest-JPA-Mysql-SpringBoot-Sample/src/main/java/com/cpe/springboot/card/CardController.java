package com.cpe.springboot.card;

import com.cpe.springboot.model.Card;
import com.cpe.springboot.model.User;
import com.cpe.springboot.user.UserService;
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

    @Autowired
    UserService uService;

    //Route d'accès à une carte par son Id
    @RequestMapping(method= RequestMethod.GET,value="/card/{id}")
    public Card getCard(@PathVariable String id) {
        Card c = cService.getCard(Integer.valueOf(id));

        return c;
    }

    //Route d'accès à une carte par son nom
    @RequestMapping(method= RequestMethod.GET,value="/cardName/{name}")
    public Card getCardByName(@PathVariable String name) {
        Card c = cService.getCardByName(name);

        return c;
    }

    //Route d'accès aux cartes
    @RequestMapping(method= RequestMethod.GET,value="/cards")
    public List<Card> getCards() {
        List<Card> lC = cService.getCards();

        return lC;
    }

    //Vend une carte
    @RequestMapping(method= RequestMethod.PATCH,value="/card/{name}/sell")
    public ResponseEntity getCards(@PathVariable String name) {
        Card card = cService.getCardByName(name);

        card.setOnSale(true);
        cService.updateCard(card);

        return new ResponseEntity(HttpStatus.OK);
    }

    //Achète une carte
    @RequestMapping(method= RequestMethod.PATCH,value="/buyCard/{name}/{userId}")
    public ResponseEntity buyCard(@PathVariable String name, @PathVariable String userId) {
        Card c = cService.getCardByName(name);
        User uBuy = uService.getUserById(Integer.valueOf(userId));
        User uSale = uService.getUserById(c.getUserId());

        uSale.setMoney(uSale.getMoney() + c.getPrice());
        uBuy.setMoney(uBuy.getMoney() - c.getPrice());
        c.setUser(uBuy);
        c.setOnSale(false);
        cService.updateCard(c);

        return new ResponseEntity(HttpStatus.OK);
    }
}
