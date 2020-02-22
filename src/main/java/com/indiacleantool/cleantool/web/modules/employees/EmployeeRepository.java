package com.indiacleantool.cleantool.web.modules.employees;

import com.indiacleantool.cleantool.web.domain.employee.Employee;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {

    @Procedure(name = "generateEmployeeCode")
    String generateEmployeeCode(@Param("empId") Long empId);

    Employee findByEmployeeCode(String employeeCode);

    @Procedure(name = "deleteEmployeeByCode")
    void deleteEmployeeByCode(@Param("empCode") String empCode);



}
