package com.demo.survey.security.controller;

import com.demo.survey.entity.User;
import com.demo.survey.repository.UserRepository;
import com.demo.survey.security.config.WebSecurityConfig;
import com.demo.survey.security.dto.UserDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@Log4j2
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    /**
     * looks up the user in the database and compares the passwords to validate.
     * If everything is correct, the token is returned.
     * @param userDto
     * @return
     */
    @PostMapping("login")
    public String login(@RequestBody UserDto userDto){

        Optional<User> user = userRepository.findOneByUsername(userDto.getUser());

        if(!user.isPresent() || !passwordEncoder.matches(userDto.getPwd(), user.get().getPassword())){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        String token = WebSecurityConfig.getJWTToken(userDto.getUser());

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


}
