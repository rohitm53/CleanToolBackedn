package com.indiacleantool.cleantool.web.modules.employeeservice;

import com.indiacleantool.cleantool.web.domain.employeeservice.EmployeeServiceRequest;
import com.indiacleantool.cleantool.web.exceptions.MapValidationExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/employeeservice")
public class EmployeeServiceController {

    @Autowired
    private EmployeeServiceSprService service;

    @Autowired
    private MapValidationExceptionService mapValidationExceptionService;

    @PostMapping
    public ResponseEntity<?> saveEmployeeService(@Valid @RequestBody EmployeeServiceRequest request , BindingResult result){
        ResponseEntity<?> errorMap = mapValidationExceptionService.validateRESTRequest(result);
        if(errorMap!=null){
            return errorMap;
        }
        return new ResponseEntity<>(service.saveEmployeeService(request), HttpStatus.OK);
    }
}
