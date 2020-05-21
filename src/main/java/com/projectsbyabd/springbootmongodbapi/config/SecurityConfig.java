package com.projectsbyabd.springbootmongodbapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ADMIN = "ADMIN";
    private static final String USER = "USER";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles(USER)
                .and()
                .withUser("admin").password("{noop}password").roles(USER, ADMIN);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/getAllUsers").hasRole(USER)
                .antMatchers(HttpMethod.GET, "/getPageUsers/**").hasRole(USER)
                .antMatchers(HttpMethod.GET, "/getUserById/**").hasRole(USER)
                .antMatchers(HttpMethod.POST, "/createUser").hasRole(ADMIN)
                .antMatchers(HttpMethod.DELETE, "/deleteUser/**").hasRole(ADMIN)
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

}