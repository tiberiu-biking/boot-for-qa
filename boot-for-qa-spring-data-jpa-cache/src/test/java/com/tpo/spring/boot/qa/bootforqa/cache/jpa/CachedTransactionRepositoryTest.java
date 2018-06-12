package com.tpo.spring.boot.qa.bootforqa.cache.jpa;

import com.tpo.spring.boot.qa.bootforqa.SpringBootForQaJpaCacheApplication;
import com.tpo.spring.boot.qa.bootforqa.cache.jpa.transaction.CachedTransactionRepository;
import com.tpo.spring.boot.qa.bootforqa.cache.jpa.transaction.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringBootForQaJpaCacheApplication.class)
@ActiveProfiles("dev")
class CachedTransactionRepositoryTest {

    @Autowired
    private CachedTransactionRepository transactionRepository;

    @BeforeEach
    void setUp() {
        transactionRepository.saveAll(buildTransactions(3));
    }

    @AfterEach
    void tearDown() {
        transactionRepository.deleteAll();
    }

    @Test
    void demoRepositoryWithCache() {
        assertEquals(1, transactionRepository.findByAmount(100).size());
        assertEquals(1, transactionRepository.findByAmount(100).size());
        assertEquals(1, transactionRepository.findByAmount(200).size());
        assertEquals(1, transactionRepository.findByAmount(200).size());
        assertEquals(1, transactionRepository.findByAmount(100).size());
    }

    private List<Transaction> buildTransactions(int count) {
        return LongStream.range(0, count)
                         .mapToObj(this::buildTransaction)
                         .collect(Collectors.toList());
    }

    private Transaction buildTransaction(long id) {
        Transaction transaction = new Transaction();
        transaction.setId(id);
        transaction.setAmount((id + 1) * 100);
        transaction.setCurrency("EUR");
        transaction.setCreationDate(Timestamp.from(Instant.now()));
        return transaction;

    }

}