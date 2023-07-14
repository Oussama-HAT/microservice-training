package com.sqli.transactionservice.mapper;

import com.sqli.transactionservice.dto.TransactionRequestDto;
import com.sqli.transactionservice.entities.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TransactionMapper implements Mapper<TransactionRequestDto, Transaction> {

    @Override
    public TransactionRequestDto entityToDto(Transaction entity) {
        return null;
    }

    @Override
    public Transaction dtoToEntity(TransactionRequestDto dto) {
        if(dto == null){
            return null;
        }
        return Transaction.builder()
                .amount(dto.amount())
                .transactionType(dto.transactionType())
                .purpose(dto.purpose())
                .accountTo(dto.accountTo())
                .accountFrom(dto.accountFrom())
                .accountBalance(dto.accountBalance())
                .build();
    }

    @Override
    public List<Transaction> dtoToEntityList(List<TransactionRequestDto> dtoList) {
        return Mapper.super.dtoToEntityList(dtoList);
    }

    @Override
    public List<TransactionRequestDto> entityToDtoList(List<Transaction> entities) {
        return Mapper.super.entityToDtoList(entities);
    }
}


