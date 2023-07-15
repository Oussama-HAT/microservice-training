package com.sqli.customerservice.mappers;

import com.sqli.customerservice.dto.AccountRequestDto;
import com.sqli.customerservice.entities.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AccountRequestMapper implements Mapper<AccountRequestDto, Account> {

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public AccountRequestDto entityToDto(Account entity) {
        return entity != null ? new AccountRequestDto(entity.getAccountNo(), entity.getUsername(),null,null,null) : null;
    }

    @Override
    public Account dtoToEntity(AccountRequestDto dto) {
        return dto != null ? new Account(dto.accountNo(), dto.username(),passwordEncoder.encode(dto.password()),dto.token() ) : null;
    }

    @Override
    public List<Account> dtoToEntityList(List<AccountRequestDto> dtoList) {
        return Mapper.super.dtoToEntityList(dtoList);
    }

    @Override
    public List<AccountRequestDto> entityToDtoList(List<Account> entities) {
        return Mapper.super.entityToDtoList(entities);
    }
}
