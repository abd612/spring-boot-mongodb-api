package com.projectsbyabd.springbootmongodbapi.service;

import com.projectsbyabd.springbootmongodbapi.model.User;
import com.projectsbyabd.springbootmongodbapi.respository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String name, String age, String city) {
        return userRepository.save(new User(name, age, city));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getPageUsers(Pageable pageable) {
        return userRepository.findAll(pageable).getContent();
    }

    public User getUserById(String id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public User updateUserById(String id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    public User updateUserByName(String name, User user) {
        User originalUser = userRepository.findByName(name);
        user.setId(originalUser.getId());
        return userRepository.save(user);
    }

    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }

    public void deleteUserByName(String name) {
        userRepository.deleteByName(name);
    }
}
