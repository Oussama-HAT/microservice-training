package com.sqli.customerservice.controllers;

import com.sqli.customerservice.dto.AdminRequestDto;
import com.sqli.customerservice.dto.AdminResponseDto;
import com.sqli.customerservice.exception.NotFoundException;
import com.sqli.customerservice.exception.ServiceException;
import com.sqli.customerservice.services.AdministrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@Slf4j
public class AdministrationController {

    private final AdministrationService administrationService;

    @PostMapping(path="/save",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
   // @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<AdminResponseDto> create(@RequestBody AdminRequestDto admin) throws ServiceException {
        log.info("Returning to create a new admin {}", admin);

        return new ResponseEntity<>(administrationService.create(admin), HttpStatus.OK);
    }

    @PutMapping(path="/update",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<AdminResponseDto> update(@RequestBody AdminRequestDto admin) throws ServiceException {
        log.info("Returning to update an admin {}", admin);

        return new ResponseEntity<>(administrationService.update(admin), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
   // @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable("id") Long id) throws NotFoundException {
        log.info("Returning to delete admin by id {}", id);
        administrationService.delete(id);
    }

}
