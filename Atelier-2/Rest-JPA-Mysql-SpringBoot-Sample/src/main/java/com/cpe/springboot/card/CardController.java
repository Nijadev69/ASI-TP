package com.cpe.springboot.card;

import com.cpe.springboot.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {

    @Autowired
    CardService cService;

    @RequestMapping(method= RequestMethod.GET,value="/card/{id}")
    public Card getCard(@PathVariable String id) {
        Card c = cService.getCard(Integer.valueOf(id));

        return c;
    }

    @RequestMapping(method= RequestMethod.GET,value="/cardName/{name}")
    public Card getCardByName(@PathVariable String name) {
        Card c = cService.getCardByName(name);

        return c;
    }

    @RequestMapping(method= RequestMethod.GET,value="/cards")
    public List<Card> getCards() {
        List<Card> lC = cService.getCards();

        return lC;
    }

    @RequestMapping(method= RequestMethod.PATCH,value="/card/{name}/sell")
    public Card getCards(@PathVariable String name) {
        Card card = cService.getCardByName(name);
        card.setOnSale(true);

        return card;
    }
}
