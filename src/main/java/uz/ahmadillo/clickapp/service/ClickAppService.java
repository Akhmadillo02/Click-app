package uz.ahmadillo.clickapp.service;

import org.springframework.stereotype.Service;
import uz.ahmadillo.clickapp.entity.Card;
import uz.ahmadillo.clickapp.entity.TransactionHistory;
import uz.ahmadillo.clickapp.entity.User;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class ClickAppService {
    private final UserService userService;

    private final CardService cardService;

    private final TransactionHistoryService transactionHistoryService;

    public ClickAppService(UserService userService, CardService cardService, TransactionHistoryService transactionHistoryService) {
        this.userService = userService;
        this.cardService = cardService;
        this.transactionHistoryService = transactionHistoryService;
    }

    @Transactional
    public void transferMoney(Long userId, Long sourceCardId, Long destinationCardId, double amount) {
        User sourceUser = userService.getUserById(userId);
        Card sourceCard = cardService.getCardById(sourceCardId);
        Card destinationCard = cardService.getCardById(destinationCardId);

        double commission = amount * 0.01;
        sourceUser.setBalance(sourceUser.getBalance() - amount - commission);
        sourceCard.setBalance(sourceCard.getBalance() - amount - commission);

        double transactionCommission = amount * 0.005;
        destinationCard.setBalance(destinationCard.getBalance() + amount - transactionCommission);

        userService.updateUser(userId, sourceUser);
        cardService.updateCard(sourceCardId, sourceCard);
        cardService.updateCard(destinationCardId, destinationCard);

        TransactionHistory transactionHistory = new TransactionHistory();
        transactionHistory.setAmount(amount);
        transactionHistory.setDate(new Date());
        transactionHistory.setSourceCard(sourceCard);
        transactionHistory.setDestinationCard(destinationCard);

        transactionHistoryService.createTransaction(transactionHistory);
    }

}

