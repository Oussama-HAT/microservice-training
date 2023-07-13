package com.sqli.administrationservice.services;

import com.sqli.administrationservice.dto.AdminRequestDto;
import com.sqli.administrationservice.dto.AdminResponseDto;
import com.sqli.administrationservice.exception.NotFoundException;
import com.sqli.administrationservice.exception.ServiceException;

import java.util.List;

public interface AdministrationService {

    AdminResponseDto create(AdminRequestDto reponse) throws ServiceException;

    AdminResponseDto update(AdminRequestDto reponse) throws ServiceException;

    void delete(Long id) throws NotFoundException;

}
