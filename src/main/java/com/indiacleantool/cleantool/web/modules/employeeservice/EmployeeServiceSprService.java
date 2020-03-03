package com.indiacleantool.cleantool.web.modules.employeeservice;

import com.indiacleantool.cleantool.web.domain.employeeservice.EmployeeService;
import com.indiacleantool.cleantool.web.domain.employeeservice.EmployeeServiceRequest;
import com.indiacleantool.cleantool.web.domain.employeeservice.EmployeeServiceRequestBody;
import com.indiacleantool.cleantool.web.exceptions.employeeservice.EmployeeServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceSprService {

    @Autowired
    private EmployeeServiceRepository repository;

    public Iterable<EmployeeService> saveEmployeeService(EmployeeServiceRequest employeeServiceRequest) {

        if(employeeServiceRequest.getEmployeeServices()==null){
            throw new EmployeeServiceException("No Service code list available");
        }
        repository.deleteEmployeeServicebyCompanyCode(employeeServiceRequest.getCompanyCode());
        List<EmployeeService> listEmployeeServices = new ArrayList<>();
        String companyCode = employeeServiceRequest.getCompanyCode();
        for(EmployeeServiceRequestBody employeeServiceRequestBody : employeeServiceRequest.getEmployeeServices()){
            for(String serviceCode : employeeServiceRequestBody.getServiceCodes()){
                EmployeeService employeeService = new EmployeeService();
                employeeService.setCompanyCode(companyCode);
                employeeService.setServiceCode(serviceCode);
                employeeService.setEmployeeCode(employeeServiceRequestBody.getEmployeeCode());
                listEmployeeServices.add(employeeService);
            }
        }
        return repository.saveAll(listEmployeeServices);
    }
}
