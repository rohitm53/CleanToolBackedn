package com.indiacleantool.cleantool.web.common.users.mobileuser;

import com.indiacleantool.cleantool.common.Constants;
import com.indiacleantool.cleantool.security.SecurityConstants;
import com.indiacleantool.cleantool.usermanagment.UserCredentialsRepository;
import com.indiacleantool.cleantool.exceptions.userexception.mobile.MobileUserCodeException;
import com.indiacleantool.cleantool.datamodels.users.mobileuser.MobileUser;
import com.indiacleantool.cleantool.datamodels.users.login.Role;
import com.indiacleantool.cleantool.datamodels.users.login.UserCredentials;
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
            saveMobileUser.setMobileUserCode(mobileUserCode);

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


    public MobileUser findMobileUserByCode(String mobile_user_code){

        MobileUser mobileUser = mobileUserRepository.findByMobileUserCode(mobile_user_code);
        if(mobileUser==null){
            throw new MobileUserCodeException("No mobile user available with code : "+mobile_user_code);
        }
        return mobileUser;
    }

}
