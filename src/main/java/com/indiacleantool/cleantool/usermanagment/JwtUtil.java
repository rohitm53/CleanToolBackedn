package com.indiacleantool.cleantool.usermanagment;

import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    private String SECRET_KEY="secret";

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }
    public Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
    }
    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims =  extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
        return createToken(claims,userDetails.getUsername());
    }

    public Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private String createToken(Map<String,Object> claims , String subject){
        return Jwts.builder().setClaims(claims)
                             .setSubject(subject)
                             .setIssuedAt(new Date(System.currentTimeMillis()))
                             .setExpiration(new Date(System.currentTimeMillis()+300000))
                             .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                     .compact();
    }

    public boolean validateJwtToken(String jwtToken){

        try{
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwtToken);
            return true;
        }catch (SignatureException e){
            System.out.println("Invalid JWT Signature");
        }catch (MalformedJwtException e){
            System.out.println("Invalid JWT Token");
        }catch (ExpiredJwtException e){
            System.out.println("Expired JWT Token");
        }catch (UnsupportedJwtException e){
            System.out.println("Unsupported JWT Token");
        }catch (IllegalArgumentException e){
            System.out.println("JWT claims string is empty");
        }
        return false;
    }

}
