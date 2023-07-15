package com.sqli.customerservice.services;

import com.sqli.customerservice.dto.AdminRequestDto;
import com.sqli.customerservice.dto.AdminResponseDto;
import com.sqli.customerservice.entities.Admin;
import com.sqli.customerservice.exception.NotFoundException;
import com.sqli.customerservice.exception.ServiceException;
import com.sqli.customerservice.mappers.AdminRequestMapper;
import com.sqli.customerservice.mappers.AdminResponseMapper;
import com.sqli.customerservice.repository.AdminRepository;
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
public class AdministrationServiceImpl implements AdministrationService {

    private final AdminRepository adminRepository;
    private final AdminRequestMapper adminRequestMapper;
    private final AdminResponseMapper adminResponseMapper;

    @Override
    @Transactional()
    public AdminResponseDto create(AdminRequestDto adminRequestDto) throws ServiceException {

        if (adminRequestDto.adminId() != null && adminRepository.existsById(adminRequestDto.adminId())) {
            throw new ServiceException(ErrorCodeConstants.ID_ALREADY_EXIST,
                    String.format(MessageConstants.ID_ALREADY_EXIST, adminRequestDto.adminId()));
        }

        Admin admin = adminRequestMapper.dtoToEntity(adminRequestDto);
        Admin adminSaved = adminRepository.save(admin);
        return adminResponseMapper.entityToDto(adminSaved);
    }

    @Override
    public AdminResponseDto update(AdminRequestDto adminRequestDto) throws ServiceException {
        Optional<Admin> reponseOptional = adminRepository.findById(adminRequestDto.adminId());

        if (!reponseOptional.isPresent()) {
            throw new ServiceException(ErrorCodeConstants.ID_NOT_FOUNT,
                    String.format(MessageConstants.ID_NOT_FOUNT, adminRequestDto.adminId()));
        }
        Admin admin = adminRequestMapper.dtoToEntity(adminRequestDto);
        Admin adminSaved = adminRepository.save(admin);
        return adminResponseMapper.entityToDto(adminSaved);
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        Admin admin = adminRepository.findById(id).orElseThrow(() ->
                new NotFoundException(ErrorCodeConstants.ID_NOT_FOUNT,
                        String.format(MessageConstants.ID_NOT_FOUNT, id)));

        adminRepository.delete(admin);

    }

}
