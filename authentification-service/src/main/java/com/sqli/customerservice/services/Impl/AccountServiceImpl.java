package com.sqli.customerservice.services.Impl;

import com.sqli.customerservice.dto.AccountRequestDto;
import com.sqli.customerservice.dto.AccountResponseDto;
import com.sqli.customerservice.entities.Account;
import com.sqli.customerservice.exception.NotFoundException;
import com.sqli.customerservice.exception.ServiceException;
import com.sqli.customerservice.mappers.AccountRequestMapper;
import com.sqli.customerservice.mappers.AccountResponseMapper;
import com.sqli.customerservice.repository.AccountRepository;
import com.sqli.customerservice.services.AccountService;
import com.sqli.customerservice.util.ErrorCodeConstants;
import com.sqli.customerservice.util.MessageConstants;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountRequestMapper accountRequestMapper;
    private final AccountResponseMapper accountResponseMapper;
    @Override
    @Transactional()
    public AccountResponseDto create(AccountRequestDto accountRequestDto) throws ServiceException {

        if (accountRequestDto.accountNo() != null && accountRepository.existsById(accountRequestDto.accountNo())) {
            throw new ServiceException(ErrorCodeConstants.ID_ALREADY_EXIST,
                    String.format(MessageConstants.ID_ALREADY_EXIST, accountRequestDto.accountNo()));
        }
        Account account = accountRequestMapper.dtoToEntity(accountRequestDto);
        Account accountSaved = accountRepository.save(account);
        return accountResponseMapper.entityToDto(accountSaved);
    }

    @Override
    public AccountResponseDto update(AccountRequestDto accountRequestDto) throws ServiceException {
        Optional<Account> reponseOptional = accountRepository.findById(accountRequestDto.accountNo());

        if (!reponseOptional.isPresent()) {
            throw new ServiceException(ErrorCodeConstants.ID_NOT_FOUNT,
                    String.format(MessageConstants.ID_NOT_FOUNT, accountRequestDto.accountNo()));
        }
        Account account = accountRequestMapper.dtoToEntity(accountRequestDto);
        Account accountSaved = accountRepository.save(account);
        return accountResponseMapper.entityToDto(accountSaved);
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        Account account = accountRepository.findById(id).orElseThrow(() ->
                new NotFoundException(ErrorCodeConstants.ID_NOT_FOUNT,
                        String.format(MessageConstants.ID_NOT_FOUNT, id)));

        accountRepository.delete(account);

    }

}
