package com.example.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.example.crud.entity.User;
import com.example.crud.userpojo.UserPojo;

public interface UserService {

	User getUserById(Integer userId);
    User getUserByfirstName(String firstName );
    void createUser(UserPojo userPojo);
     void updateUser(User updatedUser , Integer userId) ;
    List<User> getAllUsers();

}
