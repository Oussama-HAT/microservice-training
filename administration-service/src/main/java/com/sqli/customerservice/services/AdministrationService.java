package com.sqli.customerservice.services;

import com.sqli.customerservice.dto.AdminRequestDto;
import com.sqli.customerservice.dto.AdminResponseDto;
import com.sqli.customerservice.exception.NotFoundException;
import com.sqli.customerservice.exception.ServiceException;

public interface AdministrationService {

    AdminResponseDto create(AdminRequestDto reponse) throws ServiceException;

    AdminResponseDto update(AdminRequestDto reponse) throws ServiceException;

    void delete(Long id) throws NotFoundException;

}
