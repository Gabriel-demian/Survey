package com.demo.survey.security.controller;

import com.demo.survey.entity.User;
import com.demo.survey.repository.UserRepository;
import com.demo.survey.security.dto.UserDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Log4j2
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("login")
    public String login(@RequestBody UserDto userDto){

        Optional<User> user = userRepository.findOneByUsername(userDto.getUser());


        if(!user.isPresent() || !passwordEncoder.matches(userDto.getPwd(), user.get().getPassword())){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        String token = getJWTToken(userDto.getUser());

        return token;
    }

    @PostMapping("user")
    @ResponseStatus(HttpStatus.CREATED)
    public void newUser(@RequestBody UserDto userDto){

        User newUser = new User();

        newUser.setUsername(userDto.getUser());
        newUser.setPassword(passwordEncoder.encode(userDto.getPwd()));

        userRepository.save(newUser);

    }

    /**
     * getJWTToken : Build the token. Username and password are not being verified YET.
     * @param username
     * @return Bearer Token
     */
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
