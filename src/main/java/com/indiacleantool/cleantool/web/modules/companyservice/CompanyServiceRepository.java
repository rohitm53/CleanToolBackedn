package com.indiacleantool.cleantool.web.modules.companyservice;

import com.indiacleantool.cleantool.web.domain.companyservice.CompanyService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyServiceRepository extends CrudRepository<CompanyService,Long> {

    @Procedure(name = "sp_deleteCompanyServiceByCompanyCode")
    void deleteCompanyServiceByCompanyCode(@Param("the_company_code") String companyCode);
}
