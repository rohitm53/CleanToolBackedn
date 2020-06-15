package com.indiacleantool.cleantool.web.mobile.controllers;

import com.indiacleantool.cleantool.web.domain.staticservice.Services;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mobile")
public class TestMobile {

    @GetMapping("/hello")
    public ResponseEntity<?> testMobileApi(){


        Services services = new Services();
        services.setNoOfEmpReq(1);
        services.setServiceCode("TEST");
        services.setServiceName("TEST MOBILE SERVICE");

        return new ResponseEntity<>(services, HttpStatus.OK);
    }
}
