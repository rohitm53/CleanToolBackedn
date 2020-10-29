package com.indiacleantool.cleantool.web.common.bookservice;

import com.indiacleantool.cleantool.web.exceptions.MapValidationExceptionService;
import com.indiacleantool.cleantool.web.models.frontendmodals.assignemployee.AssignEmployeeRequest;
import com.indiacleantool.cleantool.web.models.mobileusermodals.bookingservicerequest.ServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/api/servicerequest")
public class BookServiceController {

    @Autowired
    private BookServiceSprService service;

    @Autowired
    private MapValidationExceptionService mapValidationExceptionService;

    @PostMapping("/book")
    public ResponseEntity<?> saveServiceRequest(@Valid @RequestBody ServiceRequest serviceRequest, BindingResult result){

        ResponseEntity<?> erroMap = mapValidationExceptionService.validateRESTRequest(result);
        if(erroMap!=null){
            return erroMap;
        }
        return new ResponseEntity<>(service.saveServiceRequest(serviceRequest), HttpStatus.OK);

    }

    @GetMapping("/mobile")
    public ResponseEntity<?> getAllMobileUserRequest(Principal principal){
        return new ResponseEntity<>(service.getAllMobileServiceRequest(principal.getName()), HttpStatus.OK);
    }


    @GetMapping("/company")
    public ResponseEntity<?> getAllCompanyServiceRequest(Principal principal){
        return new ResponseEntity<>(service.getAllCompanyServiceRequest(principal.getName()), HttpStatus.OK);
    }


    @PostMapping("/assigneemployee")
    public ResponseEntity<?> assigneEmployeeToServiceRequest(@Valid @RequestBody AssignEmployeeRequest assignEmployeeRequest, BindingResult result,
                                            Principal principal){

        ResponseEntity<?> erroMap = mapValidationExceptionService.validateRESTRequest(result);
        if(erroMap!=null){
            return erroMap;
        }
        return new ResponseEntity<>(service.performAssignEmployeeToServiceReq(assignEmployeeRequest,principal.getName()),HttpStatus.OK);
    }

}
