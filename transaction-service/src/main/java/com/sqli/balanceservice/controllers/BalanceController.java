package com.sqli.balanceservice.controllers;

import com.sqli.balanceservice.dto.BalanceRequestDto;
import com.sqli.balanceservice.services.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/balance")
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceService balanceService;

    @GetMapping(path="/{accountId}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public BalanceRequestDto getBalance(@PathVariable("accountId") Long accountId)
    {
        return balanceService.getBalance(accountId);
    }

}
