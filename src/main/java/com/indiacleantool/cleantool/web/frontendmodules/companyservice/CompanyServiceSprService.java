package com.indiacleantool.cleantool.web.frontendmodules.companyservice;

import com.indiacleantool.cleantool.web.models.frontendmodals.staticservice.Services;
import com.indiacleantool.cleantool.web.models.frontendmodals.companyservice.CompanyService;
import com.indiacleantool.cleantool.web.models.users.company.CompanyCodeView;
import com.indiacleantool.cleantool.web.exceptions.companyservice.CompanyServiceException;
import com.indiacleantool.cleantool.web.frontendmodules.staticservices.StaticServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceSprService {

    @Autowired
    private CompanyServiceRepository repository;

    @Autowired
    private StaticServiceRepository staticServiceRepository;

    public Iterable<CompanyService> saveCompanyService(String compananyCode , List<String> listServiceCode){

        if(listServiceCode==null){
            throw new CompanyServiceException("No Service code list available");
        }
        repository.deleteCompanyServiceByCompanyCode(compananyCode);
        List<CompanyService> listCompanyService = new ArrayList<>();
        for(String serviceCode : listServiceCode){
            CompanyService companyService = new CompanyService();
            companyService.setCompanyCode(compananyCode);
            companyService.setServiceCode(serviceCode);
            listCompanyService.add(companyService);
        }
        return repository.saveAll(listCompanyService);
    }

    public Iterable<Services> getServicesForCompanybyCompanyCode(String companyCode){
        return staticServiceRepository.getServicesForCompanybyCompanyCode(companyCode);
    }

    public Long getCountByCompanyCode(String companyCode){
        return repository.countByCompanyCode(companyCode);
    }

    public List<CompanyCodeView> getCompanyCodeByServiceCode(String serviceCode){
        return repository.findByServiceCode(serviceCode);
    }
}
