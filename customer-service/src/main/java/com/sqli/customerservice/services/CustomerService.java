package com.sqli.customerservice.services;

import com.sqli.customerservice.dto.CustomerRequestDto;
import com.sqli.customerservice.dto.CustomerResponseDto;
import com.sqli.customerservice.exception.NotFoundException;
import com.sqli.customerservice.exception.ServiceException;

public interface CustomerService {

    CustomerResponseDto create(CustomerRequestDto customerRequestDto) throws ServiceException;

    CustomerResponseDto update(CustomerRequestDto customerRequestDto) throws ServiceException;

    void delete(Long id) throws NotFoundException;

}
