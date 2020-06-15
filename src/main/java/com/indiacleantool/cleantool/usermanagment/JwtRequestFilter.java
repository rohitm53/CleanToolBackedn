package com.indiacleantool.cleantool.usermanagment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.indiacleantool.cleantool.security.SecurityConstants.HEADER_STRING;
import static com.indiacleantool.cleantool.security.SecurityConstants.TOKEN_PREFIX;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private AppUserDetailService userDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                        FilterChain filterChain) throws ServletException, IOException {

        try{

            String jwt = getJWTfromRequest(request);

            if(StringUtils.hasText(jwt) && jwtUtil.validateJwtToken(jwt) &&
                                        SecurityContextHolder.getContext().getAuthentication()==null){

                String username = jwtUtil.extractUsername(jwt);
                UserDetails userDetails = userDetailService.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken  usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,null, userDetails.getAuthorities());

                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }catch (Exception e){
            logger.error("Could not set user authentication in security context",e);
        }


        filterChain.doFilter(request,response);
    }


    private String getJWTfromRequest(HttpServletRequest httpServletRequest){

        String bearerToken = httpServletRequest.getHeader(HEADER_STRING);

        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith(TOKEN_PREFIX)){
            return bearerToken.substring(7,bearerToken.length());
        }
        return null;
    }
}
