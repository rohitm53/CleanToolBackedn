package com.indiacleantool.cleantool.web.modules.employees;

import com.indiacleantool.cleantool.web.domain.employee.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {

    @Procedure(name = "generateEmployeeCode")
    String generateEmployeeCode(@Param("empId") Long empId);

    Employee findByEmployeeCode(String employeeCode);
}
