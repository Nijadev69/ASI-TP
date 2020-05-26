package com.cpe.springboot.card;

import com.cpe.springboot.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {
    @Autowired
    CardRepository cRepository;

    public Card getCard(int id) {
        Optional<Card> cOpt = cRepository.findById(id);
        if (cOpt.isPresent()) {
            return cOpt.get();
        }else {
            return null;
        }
    }

}
