package com.indiacleantool.cleantool.web.exceptions.servicecode;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ServiceCodeException extends RuntimeException {

    public ServiceCodeException(String message) {
        super(message);
    }
}
