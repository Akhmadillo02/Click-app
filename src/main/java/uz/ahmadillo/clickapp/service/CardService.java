package uz.ahmadillo.clickapp.service;

import org.springframework.stereotype.Service;
import uz.ahmadillo.clickapp.entity.Card;
import uz.ahmadillo.clickapp.repository.CardRepository;

import java.util.List;

@Service
public class CardService {
    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getAll() {
       return cardRepository.findAll();
    }

    public Card getCardById(Long cardId) {
        return cardRepository.findById(cardId).orElseThrow();
    }

    public Card createCard(Card card) {
        return cardRepository.save(card);
    }

    public Card updateCard(Long cardId, Card card) {
        Card existingCard = cardRepository.findById(cardId).orElseThrow();
        existingCard.setCardNumber(card.getCardNumber());
        existingCard.setBalance(card.getBalance());
        return cardRepository.save(existingCard);
    }

    public void deleteCard(Long cardId) {
        cardRepository.deleteById(cardId);
    }

    public void addMoneyToCardBalance(Long cardId, double amount) {
        Card card = getCardById(cardId);
        card.setBalance(card.getBalance() + amount);
        updateCard(cardId, card);
    }
}

