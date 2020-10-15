package com.indiacleantool.cleantool.web.frontendmodules.users.mobileuser;

import com.indiacleantool.cleantool.common.Constants;
import com.indiacleantool.cleantool.security.SecurityConstants;
import com.indiacleantool.cleantool.usermanagment.UserCredentialsRepository;
import com.indiacleantool.cleantool.web.models.users.mobileuser.MobileUser;
import com.indiacleantool.cleantool.web.models.users.login.Role;
import com.indiacleantool.cleantool.web.models.users.login.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MobileUserService {

    @Autowired
    private MobileUserRepository mobileUserRepository;

    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public MobileUser saveOrUpdateMobileUser(MobileUser mobileUser){

        Long id = mobileUser.getId();
        MobileUser saveMobileUser = mobileUserRepository.save(mobileUser);

        if(id==null){

            String mobileUserCode = mobileUserRepository.generateMobileUserCode(saveMobileUser.getId());
            saveMobileUser.setMobile_user_code(mobileUserCode);

            UserCredentials userCredentials = new UserCredentials(mobileUserCode, Constants.InitialPassword);
            userCredentials.setPassword(bCryptPasswordEncoder.encode(userCredentials.getPassword()));
            List<Role> roles = new ArrayList<>();
            Role role=new Role(SecurityConstants.ROLE_MOBILE_USER);
            roles.add(role);
            userCredentials.setRoles(roles);
            userCredentials.setMobileUser(mobileUser);
            userCredentialsRepository.save(userCredentials);

        }
        return saveMobileUser;
    }
}
