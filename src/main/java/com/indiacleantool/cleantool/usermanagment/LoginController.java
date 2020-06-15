package com.indiacleantool.cleantool.usermanagment;

import com.indiacleantool.cleantool.web.domain.users.login.LoginRequest;
import com.indiacleantool.cleantool.web.domain.users.login.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AppUserDetailService userDetailService;

    @RequestMapping(value = "/authenticate",method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest loginRequest) throws Exception {

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword())
            );
        }catch (Exception e){
            throw new Exception("Incorrect username or password",e);
        }

        final UserDetails userDetails = userDetailService.loadUserByUsername(loginRequest.getUsername());

        String jwtToken = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new LoginResponse(jwtToken));
    }

}
