package com.sqli.customerservice.services.Impl;

import com.sqli.customerservice.entities.Account;
import com.sqli.customerservice.exception.ServiceException;
import com.sqli.customerservice.repository.AccountRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AccountRepository accountRepository;

    private final LoginHistoryServiceImpl loginHistoryService;
    public UserDetailsServiceImpl(AccountRepository accountRepository,
                                  LoginHistoryServiceImpl loginHistoryService) {
        this.accountRepository = accountRepository;
        this.loginHistoryService = loginHistoryService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return account;
    }
}
