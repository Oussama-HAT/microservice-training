package com.sqli.transactionservice.dto;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import java.math.BigDecimal;
import java.util.Date;

public record TransactionRequestDto(BigDecimal amount,
                                    String transactionType,
                                    String purpose,
                                    Long accountTo,
                                    Long accountFrom,
                                    BigDecimal accountBalance) {
}
