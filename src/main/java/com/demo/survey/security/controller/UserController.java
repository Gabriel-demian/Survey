package com.demo.survey.security.controller;

import com.demo.survey.security.dto.User;
import io.jsonwebtoken.Jwt;
import org.glassfish.jaxb.core.v2.TODO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @PostMapping("user")
    public User login(@RequestParam("user") String username, @RequestParam("password") String pwd){

        String token = getJWTToken(username);
        User user = new User();
        user.setUser(username);
        user.setToken(token);

        return user;
    }

    /**
     * getJWTToken : Build the token. Username and password are not being verified YET.
     * @param username
     * @return Bearer Token
     */
    //TODO verify username and password
    private String getJWTToken(String username){

        String secretKey = "mySecretKey";

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts.builder()
                .setId("surveyJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }

}
