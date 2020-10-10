package com.indiacleantool.cleantool.web.frontendmodules.users.company;

import com.indiacleantool.cleantool.web.domain.users.company.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company,Long> {

    Company findByCompanyCode(String company_code);

}
