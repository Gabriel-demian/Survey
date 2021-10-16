package com.demo.survey.security.config;

import com.demo.survey.security.JWTAuthorizationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http.csrf().disable()
                .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/user").permitAll()
                .antMatchers(HttpMethod.POST,"/survey/**/**").permitAll()
                .antMatchers(HttpMethod.GET,"/surveyList").permitAll()
                .antMatchers(HttpMethod.GET,"/survey/user/**").permitAll()
                .antMatchers(HttpMethod.GET,"/survey/**").permitAll()
                .antMatchers(HttpMethod.GET,"/surveyList/label/**").permitAll()
                .antMatchers(HttpMethod.GET,"/randomSurvey").permitAll()
                .anyRequest().authenticated();

    }

}
