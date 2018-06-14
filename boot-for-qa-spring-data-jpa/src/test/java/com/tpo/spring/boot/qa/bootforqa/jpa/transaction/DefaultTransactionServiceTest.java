package com.tpo.spring.boot.qa.bootforqa.jpa.transaction;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("dev")
class DefaultTransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @Test
    void getTransactionsCount() {
        transactionService.generateTransaction();
        transactionService.generateTransaction();
        Assertions.assertEquals(2, transactionService.getCount());
    }
}