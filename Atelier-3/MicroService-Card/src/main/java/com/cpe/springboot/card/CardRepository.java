package com.cpe.springboot.card;

import com.cpe.springboot.model.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends CrudRepository<Card, Integer> {
    public Optional<Card> findByName(String name);
    public Optional<Card> findById(int id);
    public List<Card> findAll();
}
