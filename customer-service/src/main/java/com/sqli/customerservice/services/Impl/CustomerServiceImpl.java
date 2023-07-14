package com.sqli.customerservice.services.Impl;

import com.sqli.customerservice.dto.CustomerRequestDto;
import com.sqli.customerservice.dto.CustomerResponseDto;
import com.sqli.customerservice.entities.Customer;
import com.sqli.customerservice.exception.NotFoundException;
import com.sqli.customerservice.exception.ServiceException;
import com.sqli.customerservice.mappers.CustomerRequestMapper;
import com.sqli.customerservice.mappers.CustomerResponseMapper;
import com.sqli.customerservice.repository.CustomerRepository;
import com.sqli.customerservice.services.CustomerService;
import com.sqli.customerservice.util.ErrorCodeConstants;
import com.sqli.customerservice.util.MessageConstants;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerRequestMapper customerRequestMapper;
    private final CustomerResponseMapper customerResponseMapper;
    @Override
    @Transactional()
    public CustomerResponseDto create(CustomerRequestDto customerRequestDto) throws ServiceException {

        if (customerRequestDto.accountNo() != null && customerRepository.existsById(customerRequestDto.accountNo())) {
            throw new ServiceException(ErrorCodeConstants.ID_ALREADY_EXIST,
                    String.format(MessageConstants.ID_ALREADY_EXIST, customerRequestDto.accountNo()));
        }

        Customer customer = customerRequestMapper.dtoToEntity(customerRequestDto);
        Customer customerSaved = customerRepository.save(customer);
        return customerResponseMapper.entityToDto(customerSaved);
    }

    @Override
    public CustomerResponseDto update(CustomerRequestDto customerRequestDto) throws ServiceException {
        Optional<Customer> reponseOptional = customerRepository.findById(customerRequestDto.accountNo());

        if (!reponseOptional.isPresent()) {
            throw new ServiceException(ErrorCodeConstants.ID_NOT_FOUNT,
                    String.format(MessageConstants.ID_NOT_FOUNT, customerRequestDto.accountNo()));
        }
        Customer customer = customerRequestMapper.dtoToEntity(customerRequestDto);
        Customer customerSaved = customerRepository.save(customer);
        return customerResponseMapper.entityToDto(customerSaved);
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        Customer customer = customerRepository.findById(id).orElseThrow(() ->
                new NotFoundException(ErrorCodeConstants.ID_NOT_FOUNT,
                        String.format(MessageConstants.ID_NOT_FOUNT, id)));

        customerRepository.delete(customer);

    }

}
