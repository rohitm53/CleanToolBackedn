package com.indiacleantool.cleantool.mobile.staticServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/mobile/services")
public class StaticServiceController {

    @Autowired
    private StaticServicesService staticServicesService;

    @GetMapping
    public ResponseEntity<?> getAllStaticService(){
        return new ResponseEntity<List<StaticService>>(staticServicesService.getALlServices(), HttpStatus.OK);
    }
}
