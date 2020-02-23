package com.indiacleantool.cleantool.web.modules.companyservice;

import com.indiacleantool.cleantool.web.domain.Services;
import com.indiacleantool.cleantool.web.domain.companyservice.CompanyService;
import com.indiacleantool.cleantool.web.exceptions.companyservice.CompanyServiceException;
import com.indiacleantool.cleantool.web.modules.staticservices.StaticServiceRepository;
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
        try{
            repository.deleteCompanyServiceByCompanyCode(compananyCode);
            List<CompanyService> listCompanyService = new ArrayList<>();
            for(String serviceCode : listServiceCode){
                CompanyService companyService = new CompanyService();
                companyService.setCompanyCode(compananyCode);
                companyService.setServiceCode(serviceCode);
                listCompanyService.add(companyService);
            }
            return repository.saveAll(listCompanyService);
        }catch (Exception ex){
            throw new CompanyServiceException("No Service code list available");
        }
    }

    public Iterable<Services> getServicesForCompanybyCompanyCode(String companyCode){
        return staticServiceRepository.getServicesForCompanybyCompanyCode(companyCode);
    }
}
