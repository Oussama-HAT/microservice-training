package com.sqli.balanceservice.mappers;

import com.sqli.balanceservice.dto.BalanceRequestDto;
import com.sqli.balanceservice.dto.BalanceResponseDto;
import com.sqli.balanceservice.entities.Balance;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BalanceResponseMapper implements Mapper<BalanceResponseDto, Balance> {
    @Override
    public BalanceResponseDto entityToDto(Balance entity) {
        return entity != null ? new BalanceResponseDto(entity.getAccountId(), entity.getAccountType(), entity.getBalance()) : null;
    }

    @Override
    public Balance dtoToEntity(BalanceResponseDto dto) {
        return dto != null ? new Balance(dto.accountId(), dto.accountType(), dto.balance()) : null;
    }

    @Override
    public List<Balance> dtoToEntityList(List<BalanceResponseDto> dtoList) {
        return Mapper.super.dtoToEntityList(dtoList);
    }

    @Override
    public List<BalanceResponseDto> entityToDtoList(List<Balance> entities) {
        return Mapper.super.entityToDtoList(entities);
    }
}

