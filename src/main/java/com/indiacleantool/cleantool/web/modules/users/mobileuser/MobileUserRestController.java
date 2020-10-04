package com.indiacleantool.cleantool.web.modules.users.mobileuser;

import com.indiacleantool.cleantool.web.domain.users.MobileUser;
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
@RequestMapping("/api/users/mobileuser")
public class MobileUserRestController {

    @Autowired
    private MapValidationExceptionService mapValidationExceptionService;

    @Autowired
    private MobileUserService mobileUserService;

    @PostMapping
    public ResponseEntity<?> saveUpdateMobileUser(@Valid @RequestBody MobileUser mobileUser, BindingResult bindingResult){
        ResponseEntity<?> errorMap = mapValidationExceptionService.validateRESTRequest(bindingResult);
        if(errorMap!=null){
            return errorMap;
        }

        return new ResponseEntity<>(mobileUserService.saveOrUpdateMobileUser(mobileUser), HttpStatus.OK);
    }
}
