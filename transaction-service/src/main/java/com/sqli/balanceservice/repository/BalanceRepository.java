package com.sqli.balanceservice.repository;

import com.sqli.balanceservice.entities.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<Balance, Long> {
}
