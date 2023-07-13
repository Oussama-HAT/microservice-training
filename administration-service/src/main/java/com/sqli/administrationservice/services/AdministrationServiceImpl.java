package com.sqli.administrationservice.services;

import com.sqli.administrationservice.dto.AdminRequestDto;
import com.sqli.administrationservice.dto.AdminResponseDto;
import com.sqli.administrationservice.entities.Admin;
import com.sqli.administrationservice.exception.NotFoundException;
import com.sqli.administrationservice.exception.ServiceException;
import com.sqli.administrationservice.mappers.AdminRequestMapper;
import com.sqli.administrationservice.mappers.AdminResponseMapper;
import com.sqli.administrationservice.repository.AdminRepository;
import com.sqli.administrationservice.util.ErrorCodeConstants;
import com.sqli.administrationservice.util.MessageConstants;
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
