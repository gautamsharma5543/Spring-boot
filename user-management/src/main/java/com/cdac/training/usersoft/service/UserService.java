package com.cdac.training.usersoft.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.training.usersoft.model.User;
import com.cdac.training.usersoft.repository.userRepository;

/**
*Author :Gautam Sharma
*Date   :31-Dec-2024
*Time   :12:20:18 pm
*/

@Service
public class UserService {

	@Autowired
	private userRepository userRepository;
	
	public void registerUser(User user) {
		userRepository.save(user);
	}
	
	public Optional<User> loginUser(String email,String password){
		
		return userRepository.findByEmail(email)
				.filter(user->user.getPassword().equals(password));
	}
	
	
	
}
