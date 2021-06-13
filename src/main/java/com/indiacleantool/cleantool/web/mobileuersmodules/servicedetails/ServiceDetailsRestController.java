package com.indiacleantool.cleantool.web.mobileuersmodules.servicedetails;

import com.indiacleantool.cleantool.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/mobile/service-details")
public class ServiceDetailsRestController {

    @Autowired
    private ServiceDetailsSprService detailsSprService;

    @GetMapping("/providers")
    public ResponseEntity<?> getServiceProviderCompanyList(@RequestParam Map<String,String> params){

        String serviceCode = params.get(Constants.ParamKey_ServiceCode);
        String strDate = params.get(Constants.ParamKey_Date);

        return new ResponseEntity<>(detailsSprService.getServiceProviderCompanyList(serviceCode , strDate), HttpStatus.OK);
    }

}
