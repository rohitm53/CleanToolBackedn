package com.indiacleantool.cleantool.web.frontendmodules.users.mobileuser;

import com.indiacleantool.cleantool.web.models.users.mobileuser.MobileUser;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileUserRepository extends CrudRepository<MobileUser,Long> {

    @Procedure(name = "sp_generateMobileUserCode")
    String generateMobileUserCode(@Param("mobile_user_id") Long mobileUserId);


    MobileUser findByMobileUserCode(String mobile_user_code);

}
