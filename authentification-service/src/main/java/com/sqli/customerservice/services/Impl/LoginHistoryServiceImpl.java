package com.sqli.customerservice.services.Impl;

import com.sqli.customerservice.entities.Account;
import com.sqli.customerservice.entities.LoginHistory;
import com.sqli.customerservice.exception.ServiceException;
import com.sqli.customerservice.repository.LoginHistoryRepository;
import com.sqli.customerservice.services.LoginHistoryService;
import com.sqli.customerservice.util.ErrorCodeConstants;
import com.sqli.customerservice.util.MessageConstants;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginHistoryServiceImpl implements LoginHistoryService {

    private final LoginHistoryRepository loginHistoryRepository;

    @Transactional()
    public void create(Account account) throws ServiceException {
        LoginHistory loginHistory=new LoginHistory();
        loginHistory.setAccount(account);
        loginHistory.setLoginTime(Instant.now());
        loginHistoryRepository.save(loginHistory);
    }

    public void update(Account account) throws ServiceException {
        LoginHistory loginHistoryOptional=loginHistoryRepository.findByAccountNoAndLogoutTimeIsNull(account.getAccountNo());
        if (loginHistoryOptional==null) {
            throw new ServiceException(ErrorCodeConstants.ID_NOT_FOUNT,
                    String.format(MessageConstants.ID_NOT_FOUNT, account.getAccountNo()));
        }
        loginHistoryOptional.setLogoutTime(Instant.now());
        loginHistoryRepository.save(loginHistoryOptional);
    }

    @Override
    public List<LoginHistory> getAllLoginHistoryByAccount(Long accountNo) {
        return loginHistoryRepository.getAllLoginHistoryByAccount(accountNo);
    }


}
