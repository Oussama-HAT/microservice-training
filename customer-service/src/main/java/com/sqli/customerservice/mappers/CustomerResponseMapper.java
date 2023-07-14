package com.sqli.customerservice.mappers;

import com.sqli.customerservice.dto.CustomerResponseDto;
import com.sqli.customerservice.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerResponseMapper implements Mapper<CustomerResponseDto, Customer> {
    @Override
    public CustomerResponseDto entityToDto(Customer entity) {
        return entity != null ? new CustomerResponseDto(entity.getAccountNo(), entity.getFullName(),
                entity.getGender(),entity.getBirthDate(),entity.getMobile(),entity.getEmail()) : null;
    }

    @Override
    public Customer dtoToEntity(CustomerResponseDto dto) {
        return null;
    }

    @Override
    public List<Customer> dtoToEntityList(List<CustomerResponseDto> dtoList) {
        return Mapper.super.dtoToEntityList(dtoList);
    }

    @Override
    public List<CustomerResponseDto> entityToDtoList(List<Customer> entities) {
        return Mapper.super.entityToDtoList(entities);
    }
}
