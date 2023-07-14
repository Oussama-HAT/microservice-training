package com.sqli.balanceservice.exceptions.handler;

import com.sqli.balanceservice.exceptions.BalanceNotFoundException;
import com.sqli.balanceservice.shared.GenericResponse;
import com.sqli.balanceservice.shared.Messages;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status,
                                                                  WebRequest request) {
        List<String> details = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        GenericResponse error = new GenericResponse("Request Failed", details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BalanceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handleNotFoundException(BalanceNotFoundException exception) {
        List<String> details = new ArrayList<>();
        details.add(exception.getLocalizedMessage());
        GenericResponse response = new GenericResponse(Messages.BALANCE_NOT_FOUND, details);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
