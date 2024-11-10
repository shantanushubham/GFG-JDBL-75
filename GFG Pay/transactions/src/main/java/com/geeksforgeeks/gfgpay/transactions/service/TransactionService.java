package com.geeksforgeeks.gfgpay.transactions.service;

import com.geeksforgeeks.gfgpay.common.models.Transaction;
import com.geeksforgeeks.gfgpay.transactions.repository.TransactionRepository;
import com.geeksforgeeks.gfgpay.transactions.util.TransactionValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(Transaction transaction) {
        if (!TransactionValidation.isValidTransaction(transaction)) {
            log.info("Transaction is not possible.");
            return null;
        }
        transaction.setWasSuccessful(true);
        transaction = this.transactionRepository.save(transaction);
        log.info("Transaction successful.");
        return transaction;
    }

    public List<Transaction> getMiniStatement(UUID accountId, Instant start, Instant end) {
        List<Transaction> miniStatement = this.transactionRepository.getTransactionsForAccountInDateRange(
                accountId,
                start,
                end,
                Sort.by(Sort.Order.desc("createdAt"))
        );
        return miniStatement;
    }
}