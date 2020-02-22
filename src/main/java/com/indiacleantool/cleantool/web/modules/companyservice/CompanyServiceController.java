package com.indiacleantool.cleantool.web.modules.companyservice;

import com.indiacleantool.cleantool.web.domain.companyservice.CompanyServiceRequest;
import com.indiacleantool.cleantool.web.exceptions.MapValidationExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/companyservice")
public class CompanyServiceController {

    @Autowired
    private CompanyServiceSprService service;

    @Autowired
    private MapValidationExceptionService mapValidationExceptionService;

    @PostMapping
    public ResponseEntity<?> saveCompanyService(@Valid @RequestBody CompanyServiceRequest request , BindingResult bindingResult){

        ResponseEntity<?> errorMap = mapValidationExceptionService.validateRESTRequest(bindingResult);
        if(errorMap!=null){
            return errorMap;
        }
        return new ResponseEntity<>(service.saveCompanyService(request.getCompanyCode(),request.getServiceCodes()), HttpStatus.OK);
    }

    @GetMapping("/{companyCode}")
    public ResponseEntity<?> getServiceByCompanyCode(@PathVariable String companyCode){
        return new ResponseEntity<>(service.getServicesForCompanybyCompanyCode(companyCode),HttpStatus.OK);
    }

}
