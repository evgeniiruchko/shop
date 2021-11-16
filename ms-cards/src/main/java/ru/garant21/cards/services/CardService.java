package ru.garant21.cards.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.garant21.cards.entities.Card;
import ru.garant21.cards.repository.CardsRepository;
import ru.garant21.routing.dtos.CardDto;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardService {
    private final ModelMapper modelMapper;

    private final CardsRepository cardsRepository;

    public Optional<CardDto> findCardDtoById(Long id) {
        return cardsRepository.findById(id).map(this::toDto);
    }

    public List<CardDto> findAll() {
        return cardsRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public CardDto saveOrUpdate(CardDto cardDto) throws ParseException {
        return toDto(cardsRepository.save(toEntity(cardDto)));
    }

    public void deleteById(Long id) {
        cardsRepository.deleteById(id);
    }

    public Double totalBalance() {
        Double total = 0d;
        List<CardDto> cards = findAll();
        for (CardDto cardDto : cards) {
            total += cardDto.getBalance();
        }
        return total;
    }

    private CardDto toDto(Card card) {
        return modelMapper.map(card, CardDto.class);
    }

    private Card toEntity(CardDto cardDto) throws ParseException {
        return modelMapper.map(cardDto, Card.class);
    }

}
