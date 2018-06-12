package com.tpo.spring.boot.qa.bootforqa.jpa.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Tiberiu Popa
 * @since 6/7/2018
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByAmount(long amount);

    List<Transaction> findByAmountGreaterThan(long amount);
}
