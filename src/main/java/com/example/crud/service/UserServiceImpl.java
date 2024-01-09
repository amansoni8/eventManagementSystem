package com.example.crud.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.crud.entity.Event;
import com.example.crud.entity.User;
import com.example.crud.repository.UserRepository;
import com.example.crud.userpojo.UserPojo;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;

	@Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	
	@Override
	public User getUserById(Integer userId) {
		// TODO Auto-generated method stub
		User user=userRepository.findById(userId).get();
		return user;
		
	}  
	
	
	
	@Override
	public User getUserByfirstName(String firstName){
		User user = userRepository.findByfirstName(firstName);
		return user;
	}

	@Override
	public void createUser(UserPojo userPojo) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setFirstName(userPojo.getFirstName());
		user.setLastName(userPojo.getLastName());
		user.setEmail(userPojo.getEmail());
		user.setContact(userPojo.getContact());
		userRepository.save(user);
	}

	@Override
	public void updateUser(User user, Integer userId) {
		User u = userRepository.findById(userId).get();
		if(user.getFirstName() != null) {
			u.setFirstName(user.getFirstName());
		}
		u.setModifiedDate(new Date());
		 userRepository.save(u);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}
