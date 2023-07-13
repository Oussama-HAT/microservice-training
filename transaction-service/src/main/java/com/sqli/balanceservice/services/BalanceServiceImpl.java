package com.sqli.balanceservice.services;

import com.sqli.balanceservice.dto.BalanceRequestDto;
import com.sqli.balanceservice.mappers.BalanceMapper;
import com.sqli.balanceservice.repository.BalanceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository balanceRepository;
    private final BalanceMapper balanceMapper;

    @Override
    public BalanceRequestDto getBalance(Long accountId) {
        return balanceMapper.entityToDto(balanceRepository.findById(accountId).orElseThrow(()-> new RuntimeException("Balance not found")));
    }

    @Override
    public void updateBalance(BalanceRequestDto balanceRequestDto) {
        Long accountId = balanceRequestDto.accountId();
        BigDecimal balance = balanceRequestDto.balance();
    }
}
