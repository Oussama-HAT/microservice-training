package com.sqli.customerservice.mappers;

import com.sqli.customerservice.dto.AdminRequestDto;
import com.sqli.customerservice.entities.Admin;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminRequestMapper implements Mapper<AdminRequestDto, Admin> {
    @Override
    public AdminRequestDto entityToDto(Admin entity) {
        return entity != null ? new AdminRequestDto(entity.getAdminId(), entity.getFullName(), entity.getMobile(),entity.getEmail(),entity.getPassword()) : null;
    }

    @Override
    public Admin dtoToEntity(AdminRequestDto dto) {
        return dto != null ? new Admin(dto.adminId(), dto.fullName(), dto.mobile(),dto.email(), dto.password()) : null;
    }

    @Override
    public List<Admin> dtoToEntityList(List<AdminRequestDto> dtoList) {
        return Mapper.super.dtoToEntityList(dtoList);
    }

    @Override
    public List<AdminRequestDto> entityToDtoList(List<Admin> entities) {
        return Mapper.super.entityToDtoList(entities);
    }
}
