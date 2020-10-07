package com.indiacleantool.cleantool.web.modules.employeeservice;

import com.indiacleantool.cleantool.web.domain.employeeservice.EmployeeService;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeServiceRepository extends CrudRepository<EmployeeService,Long> {

    @Procedure(name = "sp_deleteEmployeeServiceByCompanyCode")
    void deleteEmployeeServicebyCompanyCode(@Param("the_companyCode") String companyCode);
}
