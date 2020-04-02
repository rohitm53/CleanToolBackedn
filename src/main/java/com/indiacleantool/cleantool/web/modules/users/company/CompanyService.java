package com.indiacleantool.cleantool.web.modules.users.company;

import com.indiacleantool.cleantool.web.domain.users.companyuser.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company saveCompany(Company company){
        return companyRepository.save(company);
    }
}
