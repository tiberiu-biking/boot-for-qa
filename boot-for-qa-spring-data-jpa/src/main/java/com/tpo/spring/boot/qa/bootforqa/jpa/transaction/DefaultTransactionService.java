package com.tpo.spring.boot.qa.bootforqa.jpa.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Random;

/**
 * @author Tiberiu Popa
 * @since 6/14/2018
 */
@Service
public class DefaultTransactionService implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public DefaultTransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public long getCount() {
        return transactionRepository.count();
    }

    @Override
    public void deleteAll() {
        transactionRepository.deleteAll();
    }

    @Override
    public Transaction generateTransaction() {
        Transaction transaction = new Transaction();
        transaction.setAmount(new Random().nextLong());
        transaction.setCreationDate(Timestamp.from(Instant.now()));
        transaction.setCurrency("EUR");
        transaction.setCurrency("EUR");
        return transactionRepository.saveAndFlush(transaction);
    }
}

