package com.indiacleantool.cleantool.web.exceptions.asset;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AssetException extends RuntimeException {

    public AssetException(String message) {
        super(message);
    }
}
