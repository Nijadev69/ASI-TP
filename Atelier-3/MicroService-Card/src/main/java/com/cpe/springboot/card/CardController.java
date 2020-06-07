package com.cpe.springboot.card;

import com.cpe.springboot.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
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
    public ResponseEntity buyCard(@PathVariable String name, @PathVariable int userId) throws Exception {
        Card c = cService.getCardByName(name);

        int oldUserId = c.getUserId();

        c.setOnSale(false);
        c.setUserId(userId);

        cService.updateCard(c);

        final String uri = "http://localhost:8081/setMoneyBuy/" + userId + "/" + c.getPrice();
        final String uri2 = "http://localhost:8081/setMoneySell/" + oldUserId + "/" + c.getPrice();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity<String> request = new HttpEntity(null, headers);
        URI locationHeader = restTemplate.postForLocation(new URI(uri), request);

        HttpEntity<String> request2 = new HttpEntity(null, headers);
        URI locationHeader2 = restTemplate.postForLocation(new URI(uri2), request);

        return new ResponseEntity(HttpStatus.OK);
    }

    //Route d'accès aux cartes d'un utilisateur
    @RequestMapping(method= RequestMethod.GET,value="/{id}/list")
    public List<Card> getUserCards(@PathVariable int id) {
        List<Card> lC = cService.getCardsByUserId(id);

        return lC;
    }
}
