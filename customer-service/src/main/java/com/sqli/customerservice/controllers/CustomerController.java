package com.sqli.customerservice.controllers;

import com.sqli.customerservice.dto.CustomerRequestDto;
import com.sqli.customerservice.dto.CustomerResponseDto;
import com.sqli.customerservice.exception.NotFoundException;
import com.sqli.customerservice.exception.ServiceException;
import com.sqli.customerservice.services.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping(path="/save",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
   // @PreAuthorize("hasRole('ROLE_customer')")
    public ResponseEntity<CustomerResponseDto> create(@RequestBody CustomerRequestDto customer) throws ServiceException {
        log.info("Returning to create a new customer {}", customer);

        return new ResponseEntity<>(customerService.create(customer), HttpStatus.OK);
    }

    @PutMapping(path="/update",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    //@PreAuthorize("hasRole('ROLE_customer')")
    public ResponseEntity<CustomerResponseDto> update(@RequestBody CustomerRequestDto customer) throws ServiceException {
        log.info("Returning to update an customer {}", customer);

        return new ResponseEntity<>(customerService.update(customer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
   // @PreAuthorize("hasRole('ROLE_customer')")
    public void delete(@PathVariable("id") Long id) throws NotFoundException {
        log.info("Returning to delete customer by id {}", id);
        customerService.delete(id);
    }

}
