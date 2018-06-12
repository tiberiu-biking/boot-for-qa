package com.tpo.spring.boot.qa.bootforqa.cache.jpa;

import com.tpo.spring.boot.qa.bootforqa.cache.jpa.transaction.CachedTransactionRepository;
import com.tpo.spring.boot.qa.bootforqa.cache.jpa.transaction.Transaction;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Tiberiu Popa
 * @since 6/7/2018
 */
@Configuration
@EnableTransactionManagement
@EntityScan(basePackageClasses = Transaction.class)
@EnableJpaRepositories(basePackageClasses = CachedTransactionRepository.class)
@EnableCaching
public class CachedPersistenceConfiguration {
}
