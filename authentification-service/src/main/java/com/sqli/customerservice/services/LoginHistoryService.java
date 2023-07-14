package com.sqli.customerservice.services;

import com.sqli.customerservice.entities.Account;
import com.sqli.customerservice.entities.LoginHistory;
import com.sqli.customerservice.exception.ServiceException;

import java.util.List;


public interface LoginHistoryService {

    void create(Account account) throws ServiceException;
    void update(Account account) throws ServiceException;
    List<LoginHistory> getAllLoginHistoryByAccount(Long accountNo);

}
