package com.indiacleantool.cleantool.exceptions.companyservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CompanyServiceException extends RuntimeException {
    public CompanyServiceException(String message) {
        super(message);
    }
}
