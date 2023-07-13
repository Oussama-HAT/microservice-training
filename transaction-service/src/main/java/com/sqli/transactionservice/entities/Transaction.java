package com.sqli.transactionservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trans_id")
    private Long Id;

    @Column(name = "trans_date", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date transactionDate;

    private BigDecimal amount;

    @Column(name = "trans_type", columnDefinition = "CHAR(10)")
    private String transactionType;

    private String purpose;

    @Column(name = "to_account")
    private Long accountTo;

    @Column(name = "account_no")
    private Long accountFrom;

    @Column(name = "account_bal")
    private BigDecimal accountBalance;
}
