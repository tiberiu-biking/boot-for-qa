package com.tpo.spring.boot.qa.bootforqa.jpa;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes = {PersistenceConfiguration.class})
@ActiveProfiles("dev")
public class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @BeforeEach
    public void setUp() {
        transactionRepository.saveAll(buildTransactions(3));
        transactionRepository.findAll().forEach(tx -> log.info(tx.toString()));
    }

    @AfterEach
    public void tearDown() {
        transactionRepository.deleteAll();
    }

    @Test
    public void demoRepository() {
        assertEquals(3, transactionRepository.findAll().size());

        assertNotNull(transactionRepository.findById(1L));

        assertEquals(1, transactionRepository.findByAmount(100L).size());
    }

    private List<Transaction> buildTransactions(int count) {
        return LongStream.range(0, count)
                         .mapToObj(this::buildTransaction)
                         .collect(Collectors.toList());
    }

    private Transaction buildTransaction(long id) {
        Transaction transaction = new Transaction();
        transaction.setId(id);
        transaction.setAmount(id * 100);
        transaction.setCurrency("EUR");
        transaction.setCreationDate(Timestamp.from(Instant.now()));
        return transaction;

    }

}