package com.indiacleantool.cleantool.web.modules.users.company;

import com.indiacleantool.cleantool.web.domain.users.Company;
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
@RequestMapping("/api/users/company")
public class CompanyRestController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private MapValidationExceptionService mapValidationExceptionService;

    @PostMapping
    public ResponseEntity<?> saveCompany(@Valid @RequestBody Company company, BindingResult bindingResult){

        ResponseEntity<?> errorMap = mapValidationExceptionService.validateRESTRequest(bindingResult);
        if(errorMap!=null){
            return errorMap;
        }
        return new ResponseEntity<>(companyService.saveOrUpdateCompany(company), HttpStatus.OK);
     }

}
