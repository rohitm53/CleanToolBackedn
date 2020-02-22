package com.indiacleantool.cleantool.web.modules.companyservice;

import com.indiacleantool.cleantool.web.domain.companyservice.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceSprService {

    @Autowired
    private CompanyServiceRepository repository;

    public Iterable<CompanyService> saveCompanyService(String compananyCode , List<String> listServiceCode){

        List<CompanyService> listCompanyService = new ArrayList<>();
        for(String serviceCode : listServiceCode){
            CompanyService companyService = new CompanyService();
            companyService.setCompanyCode(compananyCode);
            companyService.setServiceCode(serviceCode);;
            listCompanyService.add(companyService);
        }
        return repository.saveAll(listCompanyService);
    }
}
