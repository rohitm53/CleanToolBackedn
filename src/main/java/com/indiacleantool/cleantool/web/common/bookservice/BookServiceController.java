package com.indiacleantool.cleantool.web.common.bookservice;

import com.indiacleantool.cleantool.web.exceptions.MapValidationExceptionService;
import com.indiacleantool.cleantool.web.models.mobileusermodals.bookingservicerequest.ServiceRequest;
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


}
