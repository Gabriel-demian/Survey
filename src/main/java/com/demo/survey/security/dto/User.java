package com.demo.survey.security.dto;

import lombok.Data;

@Data
public class User {

    private String user;
    private String pwd;
    private String token;

}
