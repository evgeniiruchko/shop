package ru.garant21.cards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.garant21.cards.entities.Card;

import java.util.List;


@Repository
public interface CardsRepository extends JpaRepository<Card, Long> {

}
