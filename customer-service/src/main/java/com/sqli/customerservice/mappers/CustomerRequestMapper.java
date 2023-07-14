package com.sqli.customerservice.mappers;

import com.sqli.customerservice.dto.CustomerRequestDto;
import com.sqli.customerservice.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerRequestMapper implements Mapper<CustomerRequestDto, Customer> {
    @Override
    public CustomerRequestDto entityToDto(Customer entity) {
        return entity != null ? new CustomerRequestDto(entity.getAccountNo(), entity.getFullName(),
                entity.getGender(),entity.getBirthDate(),entity.getMobile(),entity.getEmail()) : null;
    }

    @Override
    public Customer dtoToEntity(CustomerRequestDto dto) {
        return dto != null ? new Customer(dto.accountNo(), dto.fullName(),
                dto.gender(),dto.birthDate(),dto.mobile(),dto.email()) : null;
    }

    @Override
    public List<Customer> dtoToEntityList(List<CustomerRequestDto> dtoList) {
        return Mapper.super.dtoToEntityList(dtoList);
    }

    @Override
    public List<CustomerRequestDto> entityToDtoList(List<Customer> entities) {
        return Mapper.super.entityToDtoList(entities);
    }
}
