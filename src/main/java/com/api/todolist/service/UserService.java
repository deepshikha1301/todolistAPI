package com.api.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.todolist.dto.UserDto;
import com.api.todolist.model.User;
import com.api.todolist.repository.UserRepository;

@Service
public class UserService {
	
	private static long count = 1;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;

	public void registerUser(UserDto userdto) {
		User user = new User();
		user.setId(count);
		user.setUsername(userdto.getUsername());
		user.setPassword(encoder.encode(userdto.getPassword()));
		count++;
		userRepository.registerUser(user);
	}
}
