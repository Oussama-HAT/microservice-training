package com.sqli.customerservice.controllers;

import com.sqli.customerservice.dto.AccountRequestDto;
import com.sqli.customerservice.dto.AccountResponseDto;
import com.sqli.customerservice.exception.NotFoundException;
import com.sqli.customerservice.exception.ServiceException;
import com.sqli.customerservice.services.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
@Slf4j
public class AccountController {

    private final AccountService accountService;

    @PostMapping(path="/save",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
   // @PreAuthorize("hasRole('ROLE_account')")
    public ResponseEntity<AccountResponseDto> create(@RequestBody AccountRequestDto account) throws ServiceException {
        log.info("Returning to create a new account {}", account);
        System.out.println("create ");
        return new ResponseEntity<>(accountService.create(account), HttpStatus.OK);
    }

    @PutMapping(path="/update",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    //@PreAuthorize("hasRole('ROLE_account')")
    public ResponseEntity<AccountResponseDto> update(@RequestBody AccountRequestDto account) throws ServiceException {
        log.info("Returning to update an account {}", account);

        return new ResponseEntity<>(accountService.update(account), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
   // @PreAuthorize("hasRole('ROLE_account')")
    public void delete(@PathVariable("id") Long id) throws NotFoundException {
        log.info("Returning to delete account by id {}", id);
        accountService.delete(id);
    }

}
