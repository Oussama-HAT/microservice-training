package com.sqli.customerservice.mappers;

import com.sqli.customerservice.dto.AdminResponseDto;
import com.sqli.customerservice.entities.Admin;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminResponseMapper implements Mapper<AdminResponseDto, Admin> {
    @Override
    public AdminResponseDto entityToDto(Admin entity) {
        return entity != null ? new AdminResponseDto(entity.getAdminId(), entity.getFullName(), entity.getMobile(),entity.getEmail()) : null;
    }

    @Override
    public Admin dtoToEntity(AdminResponseDto dto) {
        return dto != null ? new Admin(dto.adminId(), dto.fullName(), dto.mobile(),dto.email(),null) : null;
    }

    @Override
    public List<Admin> dtoToEntityList(List<AdminResponseDto> dtoList) {
        return Mapper.super.dtoToEntityList(dtoList);
    }

    @Override
    public List<AdminResponseDto> entityToDtoList(List<Admin> entities) {
        return Mapper.super.entityToDtoList(entities);
    }
}
