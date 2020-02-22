package com.indiacleantool.cleantool.web.exceptions;

import com.indiacleantool.cleantool.web.exceptions.companyservice.CompanyServiceException;
import com.indiacleantool.cleantool.web.exceptions.companyservice.CompanyServiceExceptionResponse;
import com.indiacleantool.cleantool.web.exceptions.employees.EmployeeCodeException;
import com.indiacleantool.cleantool.web.exceptions.employees.EmployeeCodeExceptionResponse;
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

    @ExceptionHandler
    public final ResponseEntity<?> handleEmployeeCodeException(EmployeeCodeException ex, WebRequest req){
        EmployeeCodeExceptionResponse response = new EmployeeCodeExceptionResponse(ex.getMessage());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<?> handleCompanyServiceException(CompanyServiceException ex , WebRequest req){
        CompanyServiceExceptionResponse response = new CompanyServiceExceptionResponse(ex.getMessage());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

}
