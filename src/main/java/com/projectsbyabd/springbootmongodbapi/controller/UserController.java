package com.projectsbyabd.springbootmongodbapi.controller;

import com.projectsbyabd.springbootmongodbapi.model.User;
import com.projectsbyabd.springbootmongodbapi.model.UserDTO;
import com.projectsbyabd.springbootmongodbapi.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @PostMapping(value = "/createUser")
    public User createUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        modelMapper().map(userDTO, user);
        return userService.createUser(user.getName(), user.getAge(), user.getCity());
    }

    @GetMapping(value = "/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/getPageUsers")
    public List<User> getPageUsers(@RequestParam("page") int page, @RequestParam("size") int size) {
        return userService.getPageUsers(PageRequest.of(page, size));
    }

    @GetMapping(value = "/getUserById/{id}")
    public User getUserById(@PathVariable("id") String id) {
        return userService.getUserById(id);
    }

    @GetMapping(value = "/getUserByName/{name}")
    public User getUserByName(@PathVariable("name") String name) {
        return userService.getUserByName(name);
    }

    @PutMapping(value = "/updateUserById/{id}")
    public User updateUserById(@PathVariable("id") String id, @RequestBody UserDTO userDTO) {
        User user = new User();
        modelMapper().map(userDTO, user);
        return userService.updateUserById(id, user);
    }

    @PutMapping(value = "/updateUserByName/{name}")
    public User updateUserByName(@PathVariable("name") String name, @RequestBody UserDTO userDTO) {
        User user = new User();
        modelMapper().map(userDTO, user);
        return userService.updateUserByName(name, user);
    }

    @DeleteMapping(value = "/deleteUserById/{id}")
    public void deleteUserById(@PathVariable("id") String id) {
        userService.deleteUserById(id);
    }

    @DeleteMapping(value = "/deleteUserByName/{name}")
    public void deleteUserByName(@PathVariable("name") String name) {
        userService.deleteUserByName(name);
    }

}
