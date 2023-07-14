package com.sqli.balanceservice.services;

import com.sqli.balanceservice.dto.BalanceRequestDto;
import com.sqli.balanceservice.dto.BalanceResponseDto;
import com.sqli.balanceservice.entities.Balance;
import com.sqli.balanceservice.exceptions.BalanceNotFoundException;
import com.sqli.balanceservice.mappers.BalanceMapper;
import com.sqli.balanceservice.mappers.BalanceResponseMapper;
import com.sqli.balanceservice.repository.BalanceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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
    public boolean isBalanceAvailable(Long accountId) {
        BigDecimal balance = balanceRepository.findById(accountId)
                                              .map(Balance::getBalance)
                                              .orElseThrow(()-> new BalanceNotFoundException("Balance not found"));
        return balance.compareTo(BigDecimal.ZERO) > 0;
    }

    @Override
    public void updateBalance(Long accountFrom , Long accountTo, BigDecimal amount) {
        Balance balanceFrom = balanceRepository.findById(accountFrom).get();
        Balance balanceTo = balanceRepository.findById(accountFrom).get();
        BigDecimal newBalance = balanceFrom.getBalance().subtract(amount);
        BigDecimal newBalance2 = balanceTo.getBalance().add(amount);
        balanceFrom.setBalance(newBalance);
        balanceTo.setBalance(newBalance2);
        balanceRepository.save(balanceFrom);
        balanceRepository.save(balanceTo);
    }
}
