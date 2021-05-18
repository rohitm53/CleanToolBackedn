package com.indiacleantool.cleantool.web.exceptions.servicerequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ServiceRequestException extends RuntimeException  {

    public ServiceRequestException(String message) {
        super(message);
    }
}
