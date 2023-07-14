package com.sqli.customerservice.services;

import com.sqli.customerservice.dto.AccountRequestDto;
import com.sqli.customerservice.dto.AccountResponseDto;
import com.sqli.customerservice.exception.NotFoundException;
import com.sqli.customerservice.exception.ServiceException;


public interface AccountService {

    AccountResponseDto create(AccountRequestDto reponse) throws ServiceException;

    AccountResponseDto update(AccountRequestDto reponse) throws ServiceException;

    void delete(Long id) throws NotFoundException;

}
