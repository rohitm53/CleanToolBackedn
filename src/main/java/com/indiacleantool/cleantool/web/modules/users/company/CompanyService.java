package com.indiacleantool.cleantool.web.modules.users.company;

import com.indiacleantool.cleantool.common.Constants;
import com.indiacleantool.cleantool.security.SecurityConstants;
import com.indiacleantool.cleantool.usermanagment.UserCredentialsRepository;
import com.indiacleantool.cleantool.web.domain.users.Company;
import com.indiacleantool.cleantool.web.domain.users.Role;
import com.indiacleantool.cleantool.web.domain.users.UserCredentials;
import com.indiacleantool.cleantool.web.exceptions.userexception.company.CompanyCodeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Transactional(rollbackFor = Exception.class)
    public Company saveOrUpdateCompany(Company company){

        Company updatedCompany=null;
        try{
            if(company.getId()==null){
                updatedCompany=companyRepository.save(company);

                UserCredentials userCredentials = new UserCredentials(company.getCompanyCode(), Constants.InitialPassword);
                List<Role> roles = new ArrayList<>();
                roles.add(new Role(SecurityConstants.ROLE_COMPANY));
                userCredentials.setRoles(roles);
                userCredentials.setCompany(updatedCompany);
                userCredentialsRepository.save(userCredentials);

            }else{
                updatedCompany=companyRepository.save(company);
            }
            return updatedCompany;
        }catch (Exception e){
            throw new CompanyCodeException("Company code '"+company.getCompanyCode()+"' already existed ");
        }
    }

}
