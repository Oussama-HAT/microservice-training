package com.sqli.balanceservice.controllers;

import com.sqli.balanceservice.dto.BalanceDto;
import com.sqli.balanceservice.dto.BalanceRequestDto;
import com.sqli.balanceservice.dto.BalanceResponseDto;
import com.sqli.balanceservice.services.BalanceService;
import com.sqli.balanceservice.shared.GenericResponse;
import com.sqli.balanceservice.shared.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/balance")
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceService balanceService;

    @GetMapping(path="/{accountId}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    //@PreAuthorize("hasRole('CLIENT')")
    public BalanceResponseDto getBalance(@PathVariable("accountId") Long accountId)
    {
        return balanceService.getBalance(accountId);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createBalance(@RequestBody BalanceRequestDto balanceRequestDto){
        balanceService.createBalance(balanceRequestDto);
        GenericResponse response = new GenericResponse();
        response.setMessage(Messages.BALANCE_ACCOUNT_CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> updateBalance(@RequestBody BalanceDto balanceDto) {
        balanceService.updateBalance(balanceDto);
        GenericResponse response = new GenericResponse();
        response.setMessage(Messages.BALANCE_UPDATED);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    //@PreAuthorize("hasRole('ROLE_CUSTUMER')")
    public ResponseEntity<Boolean> verifyBalance(@RequestParam("accountId") Long accountId,
                                                 @RequestParam("amount") BigDecimal amount) {

        boolean isBalanceStillAvailable = balanceService.isBalanceAvailable(accountId,amount);
        return ResponseEntity.status(HttpStatus.OK).body(isBalanceStillAvailable);
    }

}
