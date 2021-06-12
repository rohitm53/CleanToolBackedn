package com.indiacleantool.cleantool.web.companymodules.employees;

import com.indiacleantool.cleantool.common.Constants;
import com.indiacleantool.cleantool.exceptions.common.CommonGenericException;
import com.indiacleantool.cleantool.security.SecurityConstants;
import com.indiacleantool.cleantool.usermanagment.UserCredentialsRepository;
import com.indiacleantool.cleantool.datamodels.users.employee.Employee;
import com.indiacleantool.cleantool.datamodels.users.login.Role;
import com.indiacleantool.cleantool.datamodels.users.login.UserCredentials;
import com.indiacleantool.cleantool.exceptions.userexception.employees.EmployeeCodeException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;


@Service
public class EmployeeSprService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PersistenceContext
    private EntityManager entityManager;

    public Employee saveOrUpdateEmployee(Employee employee){

        try{
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
        }catch (DataIntegrityViolationException e){
            throw new CommonGenericException("EmailId/Phone number already registered");
        }
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

    public Employee findEmployeeById(Long id){

        Optional<Employee> employee = repository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }else{
            throw new EmployeeCodeException("No employee available with Id : "+id+".");
        }
    }

    public List<Employee> getAllCompanyAvailableEmployee(String companyCode, String strDate){
        try  {

            LocalDate date = LocalDate.parse(strDate);

            StringJoiner query = new StringJoiner(" ");

            query
                    .add("select * from employee where employee_code not in ")
                    .add(" ( ")
                    .add(" select emp_code from employee_assigned_service where ")
                    .add(" company_code = :company_code ")
                    .add(" and is_completed = 0 and ")
                    .add(" date(scheduled_date) = :date")
                    .add(" ) ");

            Query nativeQuery = entityManager.createNativeQuery(query.toString(),Employee.class);
            nativeQuery.setParameter("company_code",companyCode);
            nativeQuery.setParameter("date",date.toString());

            return nativeQuery.getResultList();

        } catch (DateTimeParseException e) {
            throw new CommonGenericException("Invalid date/time");
        } catch (Exception e) {
            e.printStackTrace();
            throw new CommonGenericException(e.getMessage());
        }
    }
}
