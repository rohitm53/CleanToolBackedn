package com.indiacleantool.cleantool.web.mobileuersmodules.servicedetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mobile/servicedetails")
public class ServiceDetailsRestController {

    @Autowired
    private ServiceDetailsSprService detailsSprService;

    @GetMapping("/{serviceCode}")
    public ResponseEntity<?> getServiceDetails(@PathVariable String serviceCode){
        return new ResponseEntity<>(detailsSprService.getServiceDetailsByServiceCode(serviceCode), HttpStatus.OK);
    }

}
