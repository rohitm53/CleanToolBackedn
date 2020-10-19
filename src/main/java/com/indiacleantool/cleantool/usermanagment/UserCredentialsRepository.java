package com.indiacleantool.cleantool.usermanagment;

import com.indiacleantool.cleantool.web.models.users.login.UserCredentials;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialsRepository extends CrudRepository<UserCredentials,Long> {

    UserCredentials findByusernameIgnoreCase(String username);
}
