package com.api.todolist.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.api.todolist.model.User;

@Repository
public class UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static String SAVE_USER_QUERY = "insert into users (id, username, password) values (?,?,?)";
	
	public void registerUser(User user) {
		jdbcTemplate.update(SAVE_USER_QUERY, user.getId(), user.getUsername(), user.getPassword());
	}
}
