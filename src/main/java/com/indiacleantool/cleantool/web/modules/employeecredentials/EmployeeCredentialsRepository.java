package com.indiacleantool.cleantool.web.modules.employeecredentials;

import com.indiacleantool.cleantool.web.domain.employee.EmployeeCredential;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeCredentialsRepository extends CrudRepository<EmployeeCredential,Long> {
}
