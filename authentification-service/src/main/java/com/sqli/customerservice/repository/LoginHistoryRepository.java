package com.sqli.customerservice.repository;

import com.sqli.customerservice.entities.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {
    @Query("SELECT l FROM LoginHistory l WHERE l.account.accountNo = :accountNo and l.logoutTime is null")
    LoginHistory findByAccountNoAndLogoutTimeIsNull(@Param("accountNo") Long accountNo);

    @Query("SELECT l FROM LoginHistory l WHERE l.account.accountNo = :accountNo")
    List<LoginHistory> getAllLoginHistoryByAccount(@Param("accountNo") Long accountNo);
}
