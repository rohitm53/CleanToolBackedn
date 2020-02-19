package com.indiacleantool.cleantool.web.modules.companyservice;

import com.indiacleantool.cleantool.web.domain.companyservice.CompanyService;
import org.springframework.data.repository.CrudRepository;

public interface CompanyServiceRepository extends CrudRepository<CompanyService,Long> {
}
