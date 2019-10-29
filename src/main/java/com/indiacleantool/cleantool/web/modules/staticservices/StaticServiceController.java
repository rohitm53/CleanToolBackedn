package com.indiacleantool.cleantool.web.modules.staticservices;

import com.indiacleantool.cleantool.web.domain.Services;
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
@RequestMapping("/api/services")
public class StaticServiceController {

    @Autowired
    private StaticServicesService service;

    @PostMapping("")
    public ResponseEntity<?> createNewService(@Valid @RequestBody Services services , BindingResult result){
        return new ResponseEntity<>("Request recieved", HttpStatus.OK);
    }

}
