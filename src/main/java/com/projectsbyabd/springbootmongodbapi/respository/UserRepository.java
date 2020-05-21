package com.projectsbyabd.springbootmongodbapi.respository;

import com.projectsbyabd.springbootmongodbapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, String> {
    void deleteByName(String name);
    User findByName(String name);
}
