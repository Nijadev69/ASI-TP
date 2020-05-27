package com.cpe.springboot.card;

import com.cpe.springboot.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    CardRepository cRepository;

    //Récupère un carte par son Id
    public Card getCard(int id) {
        Optional<Card> cOpt = cRepository.findById(id);
        if (cOpt.isPresent()) {
            return cOpt.get();
        } else {
            return null;
        }
    }

    //Récupère une carte par son nom
    public Card getCardByName(String name) {
        Optional<Card> cOpt = cRepository.findByName(name);

        if (cOpt.isPresent()) {
            return cOpt.get();
        }else {
            return null;
        }
    }

    //Récupère les cartes d'un utilisateur
    public List<Card> getCardsByUserId(int id) {
        return cRepository.findByUserId(id);
    }

    //Récupère les cartes dans la BD
    public List<Card> getCards() {
        return cRepository.findAll();
    }

    //Modifie une carte dans la BD
    public Card updateCard(Card c) {
        Card card = cRepository.save(c);

        return card;
    }

}
