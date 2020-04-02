package com.indiacleantool.cleantool.web.modules.users.company;

import com.indiacleantool.cleantool.web.domain.users.companyuser.Company;
import com.indiacleantool.cleantool.web.exceptions.MapValidationExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/company/")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private MapValidationExceptionService mapValidationExceptionService;

    @PostMapping("/savecompanydetails")
    public ResponseEntity<?> postCompany(@RequestBody Company company, BindingResult result){

        ResponseEntity<?> errorMap = mapValidationExceptionService.validateRESTRequest(result);
        if(errorMap!=null){
            return errorMap;
        }
        return new ResponseEntity<>(companyService.saveCompany(company), HttpStatus.OK);
    }

}
