package com.indiacleantool.cleantool.web.modules.employeecredentials;

import com.indiacleantool.cleantool.web.domain.employee.EmployeeCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCredentialService {

    @Autowired
    private EmployeeCredentialsRepository repository;

    public EmployeeCredential saveOrUpdateEmployeeCredentials(EmployeeCredential employeeCredential){
        return repository.save(employeeCredential);
    }
}
