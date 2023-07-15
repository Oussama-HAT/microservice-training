package com.sqli.customerservice.repository;

import com.sqli.customerservice.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
   Account findByUsername(String userName);
}
