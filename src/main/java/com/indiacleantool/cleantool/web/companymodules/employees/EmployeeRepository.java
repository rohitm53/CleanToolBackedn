package com.indiacleantool.cleantool.web.companymodules.employees;

import com.indiacleantool.cleantool.datamodels.users.employee.Employee;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {

    @Procedure(name = "sp_generateEmployeeCode")
    String generateEmployeeCode(@Param("empId") Long empId);

    Employee findByEmployeeCode(String employeeCode);

    Iterable<Employee> findAllByCompanyCode(String companyCode);

    long countByCompanyCode(String companyCode);




}
