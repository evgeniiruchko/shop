package ru.garant21.cards.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.garant21.cards.services.CardService;
import ru.garant21.routing.dtos.CardDto;
import java.text.ParseException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/card")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @GetMapping
    public Double totalBonus() {
        return cardService.totalBalance();
    }

    @GetMapping("/{id}")
    public Optional<CardDto> getCardById(@PathVariable Long id) {
        return cardService.findCardDtoById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CardDto saveNewCard(@RequestBody CardDto cardDto) throws ParseException {
        return cardService.saveOrUpdate(cardDto);
    }

    @PutMapping
    public CardDto updateCard(@RequestBody CardDto cardDto) throws ParseException {
        return cardService.saveOrUpdate(cardDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        cardService.deleteById(id);
    }
}
