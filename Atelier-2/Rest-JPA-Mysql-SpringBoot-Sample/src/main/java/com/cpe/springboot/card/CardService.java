package com.cpe.springboot.card;

import com.cpe.springboot.model.Card;
import com.cpe.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    CardRepository cRepository;

    public Card getCard(int id) {
        Optional<Card> cOpt = cRepository.findById(id);
        if (cOpt.isPresent()) {
            return cOpt.get();
        } else {
            return null;
        }
    }

    public Card getCardByName(String name) {
        Optional<Card> cOpt = cRepository.findByName(name);

        if (cOpt.isPresent()) {
            return cOpt.get();
        }else {
            return null;
        }
    }

    public List<Card> getCards() {
        return cRepository.findAll();
    }

    public Card updateCard(Card c) {
        Card card = cRepository.save(c);

        return card;
    }

}
