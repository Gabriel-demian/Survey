package com.demo.survey.security.controller;

import com.demo.survey.entity.User;
import com.demo.survey.repository.UserRepository;
import com.demo.survey.security.JWTAuthorizationFilter;
import com.demo.survey.security.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class UserController {

    private PasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    @Autowired
    public void setSurveyRepository(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setSurveyRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * looks up the user in the database and compares the passwords to validate.
     * If everything is correct, the token is returned.
     * @return token
     */
    @PostMapping("login")
    public String login(@RequestBody UserDto userDto){

        Optional<User> user = userRepository.findOneByUsername(userDto.getUser());

        if(!user.isPresent() || !passwordEncoder.matches(userDto.getPwd(), user.get().getPassword())){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        return JWTAuthorizationFilter.getJWTToken(userDto.getUser());
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
