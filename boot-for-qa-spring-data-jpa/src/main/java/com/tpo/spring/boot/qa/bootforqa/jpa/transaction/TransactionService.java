package com.tpo.spring.boot.qa.bootforqa.jpa.transaction;

/**
 * @author Tiberiu Popa
 * @since 6/14/2018
 */
public interface TransactionService {

    long getCount();

    void deleteAll();

    Transaction generateTransaction();
}
