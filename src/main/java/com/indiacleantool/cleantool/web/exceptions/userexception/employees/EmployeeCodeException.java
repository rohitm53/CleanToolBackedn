package com.indiacleantool.cleantool.web.exceptions.userexception.employees;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeCodeException extends RuntimeException {

    public EmployeeCodeException(String message){
        super(message);
    }
}
