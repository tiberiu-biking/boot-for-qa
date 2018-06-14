package com.tpo.spring.boot.qa.bootforqa.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Tiberiu Popa
 * @since 6/7/2018
 */
@Configuration
@EnableTransactionManagement
@EntityScan
@EnableJpaRepositories
public class PersistenceConfiguration {
}
