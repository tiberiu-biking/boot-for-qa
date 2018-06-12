package com.tpo.spring.boot.qa.bootforqa.cache.jpa.transaction;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * @author Tiberiu Popa
 * @since 6/7/2018
 */
@Getter
@Setter
@ToString
@Entity(name = "transactions")
public class Transaction {

    @Id
    private Long id;

    @Column
    private Timestamp creationDate;

    @Column
    private String currency;

    @Column
    private Long amount;
}
