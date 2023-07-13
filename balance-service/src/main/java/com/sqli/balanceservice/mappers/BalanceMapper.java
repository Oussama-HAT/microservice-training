package com.sqli.balanceservice.mappers;

import com.sqli.balanceservice.dto.BalanceRequestDto;
import com.sqli.balanceservice.entities.Balance;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BalanceMapper implements Mapper<BalanceRequestDto, Balance> {
    @Override
    public BalanceRequestDto entityToDto(Balance entity) {
        return entity != null ? new BalanceRequestDto(entity.getAccountId(), entity.getAccountType(), entity.getBalance()) : null;
    }

    @Override
    public Balance dtoToEntity(BalanceRequestDto dto) {
        return dto != null ? new Balance(dto.accountId(), dto.accountType(), dto.balance()) : null;
    }

    @Override
    public List<Balance> dtoToEntityList(List<BalanceRequestDto> dtoList) {
        return Mapper.super.dtoToEntityList(dtoList);
    }

    @Override
    public List<BalanceRequestDto> entityToDtoList(List<Balance> entities) {
        return Mapper.super.entityToDtoList(entities);
    }
}
