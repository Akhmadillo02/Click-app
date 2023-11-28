package uz.ahmadillo.clickapp.service;

import org.springframework.stereotype.Service;
import uz.ahmadillo.clickapp.entity.TransactionHistory;
import uz.ahmadillo.clickapp.repository.TransactionHistoryRepository;

import java.util.Date;
import java.util.List;

@Service
public class TransactionHistoryService {
    private final TransactionHistoryRepository transactionHistoryRepository;

    public TransactionHistoryService(TransactionHistoryRepository transactionHistoryRepository) {
        this.transactionHistoryRepository = transactionHistoryRepository;
    }

    public List<TransactionHistory> getAllTransactions() {
        return transactionHistoryRepository.findAll();
    }

    public TransactionHistory getTransactionById(Long transactionId) {
        return transactionHistoryRepository.findById(transactionId).orElseThrow();
    }

    public void createTransaction(TransactionHistory transactionHistory) {
        transactionHistory.setDate(new Date());
        transactionHistoryRepository.save(transactionHistory);
    }
}

