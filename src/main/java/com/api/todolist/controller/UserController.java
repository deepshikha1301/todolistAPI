package com.api.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.todolist.dto.UserDto;
import com.api.todolist.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public void registerUser(@RequestBody UserDto userdto) {
		System.out.println("****"+userdto.getUsername());
		userService.registerUser(userdto);
	}
}
