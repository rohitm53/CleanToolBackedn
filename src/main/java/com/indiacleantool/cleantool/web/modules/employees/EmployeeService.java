package com.indiacleantool.cleantool.web.modules.employees;

import com.indiacleantool.cleantool.common.Constants;
import com.indiacleantool.cleantool.web.domain.employee.Employee;
import com.indiacleantool.cleantool.web.domain.employee.EmployeeCredential;
import com.indiacleantool.cleantool.web.exceptions.employees.EmployeeCodeException;
import com.indiacleantool.cleantool.web.modules.employeecredentials.EmployeeCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeCredentialService employeeCredentialService;

    public Employee saveOrUpdateEmployee(Employee employee){

        Long id = employee.getId();
        Employee savedEmployee = repository.save(employee);
        if(id==null){
            String empCode= repository.generateEmployeeCode(savedEmployee.getId());
            savedEmployee.setEmployeeCode(empCode);
            EmployeeCredential employeeCredential = new EmployeeCredential();
            employeeCredential.setEmployeeCode(savedEmployee.getEmployeeCode());
            employeeCredential.setPassword(Constants.employeePassword);
            employeeCredentialService.saveOrUpdateEmployeeCredentials(employeeCredential);
        }
        return savedEmployee;
    }

    public Employee findByEmployeeCode(String employeeCode){

        Employee employee = repository.findByEmployeeCode(employeeCode);
        if(employee==null){
            throw new EmployeeCodeException("No employee available with code : "+employeeCode+".");
        }
        return employee;
    }

    public Iterable<Employee> findAllEmployees(){
        return repository.findAll();
    }

    public Iterable<Employee> findAllByCompanyCode(String companyCode){
        return repository.findAllByCompanyCode(companyCode);
    }

    public void deleteEmployeeByCode(String employeeCode){
        Employee employee = findByEmployeeCode(employeeCode);
        if(employee!=null){
            repository.deleteEmployeeByCode(employeeCode);
        }
    }
}
