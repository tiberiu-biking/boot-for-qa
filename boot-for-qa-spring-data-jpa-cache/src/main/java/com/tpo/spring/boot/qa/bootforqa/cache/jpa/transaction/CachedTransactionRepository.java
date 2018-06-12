package com.tpo.spring.boot.qa.bootforqa.cache.jpa.transaction;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Tiberiu Popa
 * @since 6/7/2018
 */
@Repository
public interface CachedTransactionRepository extends JpaRepository<Transaction, Long> {

    @Cacheable("byAmount")
    List<Transaction> findByAmount(long amount);
}
