package uz.ahmadillo.clickapp.controller;

import org.springframework.web.bind.annotation.*;
import uz.ahmadillo.clickapp.entity.TransactionHistory;
import uz.ahmadillo.clickapp.service.TransactionHistoryService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionHistoryService transactionHistoryService;

    public TransactionController(TransactionHistoryService transactionHistoryService) {
        this.transactionHistoryService = transactionHistoryService;
    }

    @GetMapping
    public List<TransactionHistory> getAllTransactions() {
        return transactionHistoryService.getAllTransactions();
    }

    @GetMapping("/transactionId")
    public TransactionHistory getTransactionById(@PathVariable Long transactionId) {
        return transactionHistoryService.getTransactionById(transactionId);
    }
}

