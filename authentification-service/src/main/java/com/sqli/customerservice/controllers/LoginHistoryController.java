package com.sqli.customerservice.controllers;

import com.sqli.customerservice.entities.LoginHistory;
import com.sqli.customerservice.services.LoginHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loginHistory")
@RequiredArgsConstructor
@Slf4j
public class LoginHistoryController {

    private final LoginHistoryService loginHistoryService;

    @GetMapping("/by-account/{id}")
   // @PreAuthorize("hasRole('')")
    public List<LoginHistory> findLoginHistoryByAccount(@PathVariable("accountNo") Long accountNo)  {
        return loginHistoryService.getAllLoginHistoryByAccount(accountNo);
    }

}
