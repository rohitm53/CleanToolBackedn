package com.indiacleantool.cleantool.web.exceptions;

import com.indiacleantool.cleantool.web.exceptions.servicecode.ServiceCodeException;
import com.indiacleantool.cleantool.web.exceptions.servicecode.ServiceCodeExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<?> handleServiceCodeException(ServiceCodeException ex, WebRequest req){
        ServiceCodeExceptionResponse response = new ServiceCodeExceptionResponse(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
