package com.projectsbyabd.springbootmongodbapi.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("hello")
@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello World from Spring Boot!";
    }
}
