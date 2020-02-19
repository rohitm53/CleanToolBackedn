package com.indiacleantool.cleantool.web.modules.companyservice;

import com.indiacleantool.cleantool.web.domain.companyservice.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CompanyServiceSprService {

    @Autowired
    private CompanyServiceRepository repository;

    public Iterable<CompanyService> saveCompanyService(List<CompanyService> listCompanyService){
        return repository.saveAll(listCompanyService);
    }
}
