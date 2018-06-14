package com.tpo.spring.boot.qa.bootforqa.jpa.transaction;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Timestamp creationDate;

    @Column
    private String currency;

    @Column
    private Long amount;
}
