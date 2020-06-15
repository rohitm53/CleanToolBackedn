package com.indiacleantool.cleantool.usermanagment;

import com.indiacleantool.cleantool.security.SecurityConstants;
import com.indiacleantool.cleantool.web.domain.users.Role;
import com.indiacleantool.cleantool.web.domain.users.UserCredentials;
import com.indiacleantool.cleantool.web.modules.users.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserDetailService implements UserDetailsService {

    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    private CompanyService companyService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<GrantedAuthority> authorities = new ArrayList<>();
        UserCredentials userCredentials = userCredentialsRepository.findByusername(username);

        if(userCredentials.getRoles()!=null && userCredentials.getRoles().size()>0){
            for(Role role : userCredentials.getRoles()){
                String roleName = role.getName();
                SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(getSpringConfigureRole(roleName));
                authorities.add(grantedAuthority);
            }
        }
        return new User(username,userCredentials.getPassword(),authorities);
    }

    private String getSpringConfigureRole(String role){
        return "ROLE_"+role;
    }
}
