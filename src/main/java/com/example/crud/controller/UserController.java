package com.example.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.crud.entity.Event;
import com.example.crud.entity.User;
import com.example.crud.service.UserService;
import com.example.crud.userpojo.UserPojo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
		
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable Integer userId)
	{
		return new ResponseEntity<User>( userService.getUserById(userId),  HttpStatus.OK);
	}
	
	@GetMapping("/getUserByName")
	public ResponseEntity<User> getUserByFirstName(@RequestParam String firstName ){
		return new ResponseEntity<User>(userService.getUserByfirstName(firstName), HttpStatus.OK);
	}
	
	@GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
		List<User> u = userService.getAllUsers();
        return new  ResponseEntity<List<User>>(u,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserPojo userPojo) {
    	userService.createUser(userPojo);
    	
    	return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Integer userId, @RequestBody User updatedUser) {
		updatedUser.setUserId(userId);
        userService.updateUser(updatedUser, userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

	
}
