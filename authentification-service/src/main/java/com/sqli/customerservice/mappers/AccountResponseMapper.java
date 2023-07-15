package com.sqli.customerservice.mappers;

import com.sqli.customerservice.dto.AccountResponseDto;
import com.sqli.customerservice.entities.Account;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountResponseMapper implements Mapper<AccountResponseDto, Account> {
    @Override
    public AccountResponseDto entityToDto(Account entity) {
        return entity != null ? new AccountResponseDto(entity.getAccountNo(), entity.getUsername(),entity.getToken()) : null;
    }

    @Override
    public Account dtoToEntity(AccountResponseDto dto) {
        return null;
    }

    @Override
    public List<Account> dtoToEntityList(List<AccountResponseDto> dtoList) {
        return Mapper.super.dtoToEntityList(dtoList);
    }

    @Override
    public List<AccountResponseDto> entityToDtoList(List<Account> entities) {
        return Mapper.super.entityToDtoList(entities);
    }
}
