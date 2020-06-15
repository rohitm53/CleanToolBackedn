package com.indiacleantool.cleantool.security;

import com.indiacleantool.cleantool.usermanagment.JwtRequestFilter;
import com.indiacleantool.cleantool.usermanagment.AppUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppUserDetailService myUserDetailService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                   .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                   .and()
                       .authorizeRequests().antMatchers(SecurityConstants.COMMON_USER_ENDPOINT,SecurityConstants.STATIC_SERVICE_ENDPOINT).permitAll()
                       .antMatchers(SecurityConstants.COMPANY_API_ENDPOINT).hasAnyRole(SecurityConstants.ROLE_COMPANY)
                       .antMatchers(SecurityConstants.MOBILE_API_ENDPOINT).hasAnyRole(SecurityConstants.ROLE_MOBILE_USER)
                       .antMatchers(SecurityConstants.EMPLOYEE_API_ENDPOINT).hasAnyRole(SecurityConstants.ROLE_EMPLOYEE)
                       .anyRequest().authenticated()
                   .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
