package com.indiacleantool.cleantool.web.frontendmodules.companyservice;

import com.indiacleantool.cleantool.web.models.frontendmodals.companyservice.CompanyService;
import com.indiacleantool.cleantool.web.models.users.company.CompanyCodeView;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyServiceRepository extends CrudRepository<CompanyService,Long> {

    @Procedure(name = "sp_deleteCompanyServiceByCompanyCode")
    void deleteCompanyServiceByCompanyCode(@Param("the_company_code") String companyCode);

    long countByCompanyCode(String companyCode);

    List<CompanyCodeView> findByServiceCode(String serviceCode);
}