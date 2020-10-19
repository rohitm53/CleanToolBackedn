package com.indiacleantool.cleantool.web.frontendmodules.employees;

import com.indiacleantool.cleantool.common.Constants;
import com.indiacleantool.cleantool.security.SecurityConstants;
import com.indiacleantool.cleantool.usermanagment.UserCredentialsRepository;
import com.indiacleantool.cleantool.web.models.users.employee.Employee;
import com.indiacleantool.cleantool.web.models.users.login.Role;
import com.indiacleantool.cleantool.web.models.users.login.UserCredentials;
import com.indiacleantool.cleantool.web.exceptions.userexception.employees.EmployeeCodeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Employee saveOrUpdateEmployee(Employee employee){

        Long id = employee.getId();
        Employee savedEmployee = repository.save(employee);
        if(id==null){
            String empCode= repository.generateEmployeeCode(savedEmployee.getId());
            savedEmployee.setEmployeeCode(empCode);

            UserCredentials userCredentials = new UserCredentials(empCode,Constants.InitialPassword);
            userCredentials.setPassword(bCryptPasswordEncoder.encode(userCredentials.getPassword()));
            List<Role> roles = new ArrayList<>();
            Role role = new Role(SecurityConstants.ROLE_EMPLOYEE);
            roles.add(role);
            userCredentials.setRoles(roles);
            userCredentials.setEmployee(savedEmployee);
            userCredentialsRepository.save(userCredentials);

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
            repository.delete(employee);
        }
    }

    public Long getCountByCompanyCode(String companyCode){
        return repository.countByCompanyCode(companyCode);
    }
}
