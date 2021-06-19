package com.indiacleantool.cleantool.exceptions.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CommonGenericException extends RuntimeException{

    public CommonGenericException(String message) {
        super(message);
    }
}
