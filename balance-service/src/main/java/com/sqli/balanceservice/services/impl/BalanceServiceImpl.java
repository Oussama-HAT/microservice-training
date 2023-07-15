package com.sqli.balanceservice.services.impl;

import com.sqli.balanceservice.dto.BalanceDto;
import com.sqli.balanceservice.dto.BalanceRequestDto;
import com.sqli.balanceservice.dto.BalanceResponseDto;
import com.sqli.balanceservice.entities.Balance;
import com.sqli.balanceservice.exceptions.BalanceNotFoundException;
import com.sqli.balanceservice.mappers.BalanceMapper;
import com.sqli.balanceservice.mappers.BalanceResponseMapper;
import com.sqli.balanceservice.repository.BalanceRepository;
import com.sqli.balanceservice.services.BalanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository balanceRepository;
    private final BalanceMapper balanceMapper;
    private final BalanceResponseMapper balanceResponseMapper;
    @Override
    public BalanceResponseDto getBalance(Long accountId) {
        return balanceResponseMapper.entityToDto(balanceRepository.findById(accountId).orElseThrow(()-> new BalanceNotFoundException("Balance not found")));
    }

    @Override
    public void createBalance(BalanceRequestDto balanceRequestDto) {
        Balance balance = balanceMapper.dtoToEntity(balanceRequestDto);
        balanceRepository.save(balance);
    }

    @Override
    public boolean isBalanceAvailable(Long accountId , BigDecimal amount) {
        BigDecimal balance = balanceRepository.findById(accountId)
                                              .map(Balance::getBalance)
                                              .orElseThrow(()-> new BalanceNotFoundException("Balance not found"));
        return balance.compareTo(BigDecimal.ZERO) > 0 && balance.compareTo(amount) > 0;
    }

    @Override
    public void updateBalance(BalanceDto balanceDto) {
        Balance balanceFrom = balanceRepository.findById(balanceDto.accountFrom()).get();
        Balance balanceTo = balanceRepository.findById(balanceDto.accountTo()).get();
        BigDecimal newBalance = balanceFrom.getBalance().subtract(balanceDto.amount());
        BigDecimal newBalance2 = balanceTo.getBalance().add(balanceDto.amount());
        balanceFrom.setBalance(newBalance);
        balanceTo.setBalance(newBalance2);
        balanceRepository.save(balanceFrom);
        balanceRepository.save(balanceTo);
    }
}
