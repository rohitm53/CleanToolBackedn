package com.indiacleantool.cleantool.web.modules.users.company;

import com.indiacleantool.cleantool.web.domain.users.companyuser.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company,Long> {

}
