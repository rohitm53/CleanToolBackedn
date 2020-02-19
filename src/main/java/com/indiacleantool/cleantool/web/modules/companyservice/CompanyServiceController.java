package com.indiacleantool.cleantool.web.modules.companyservice;

import com.indiacleantool.cleantool.web.domain.companyservice.CompanyServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/companyservice")
public class CompanyServiceController {

    @Autowired
    private CompanyServiceSprService service;

    @PostMapping
    public ResponseEntity<?> saveCompanyService(@Valid @RequestBody CompanyServiceRequest request , BindingResult bindingResult){
        return new ResponseEntity<>(service.saveCompanyService(request.getListCompanyServices()), HttpStatus.OK);
    }

}
