package uz.ahmadillo.clickapp.controller;

import org.springframework.web.bind.annotation.*;
import uz.ahmadillo.clickapp.entity.Card;
import uz.ahmadillo.clickapp.service.CardService;

import java.util.List;

@RestController
@RequestMapping("/cards")
@CrossOrigin("*")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAll();
    }

    @GetMapping("/{cardId}")
    public Card getCardById(@PathVariable Long cardId) {
        return cardService.getCardById(cardId);
    }

    @PostMapping("/createCard")
    public Card createCard(@RequestBody Card card) {
        return cardService.createCard(card);
    }

    @PutMapping("/{cardId}")
    public Card updateCard(@PathVariable Long cardId, @RequestBody Card card) {
        return cardService.updateCard(cardId, card);
    }

    @DeleteMapping("/cardId")
    public void deleteCard(@PathVariable Long cardId) {
        cardService.deleteCard(cardId);
    }

    @PostMapping("/{cardId}/addMoney")
    public void addMoneyToCardBalance(@PathVariable Long cardId, @RequestParam double amount) {
        cardService.addMoneyToCardBalance(cardId, amount);
    }
}

