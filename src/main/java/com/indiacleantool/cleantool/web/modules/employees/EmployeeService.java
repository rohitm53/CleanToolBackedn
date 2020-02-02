package com.indiacleantool.cleantool.web.modules.employees;

import com.indiacleantool.cleantool.web.domain.employee.Employee;
import com.indiacleantool.cleantool.web.exceptions.employees.EmployeeCodeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee saveOrUpdateEmployee(Employee employee){
        Employee savedEmployee = repository.save(employee);
        String empCode= repository.generateEmployeeCode(savedEmployee.getId());
        savedEmployee.setEmployeeCode(empCode);
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

    public void deleteEmployeeByCode(String employeeCode){
        repository.delete(findByEmployeeCode(employeeCode));
    }
}
