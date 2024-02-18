package com.api.todolist.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.api.todolist.model.Task;

@Repository
public class TaskRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static String SELECT_TASK_QUERY = "select * from tasks";
	
	private static String INSERT_TASK_QUERY = "insert into tasks (id,name) values (?,?)";
	
	private static String UPDATE_TASK_QUERY = "update tasks set name=? where id=?";
	
	private static String DELETE_TASK_QUERY = "delete from tasks where id=?";
	
	public List<Task> retrieveAllTasks(){
		return jdbcTemplate.query(SELECT_TASK_QUERY, new BeanPropertyRowMapper<>(Task.class));
	}
	
	public List<Task> addTask(Task task) {
		jdbcTemplate.update(INSERT_TASK_QUERY, task.getId(), task.getName());
		return retrieveAllTasks();
	}
	
	public List<Task> updateTask(long id, Task task) {
		jdbcTemplate.update(UPDATE_TASK_QUERY, task.getName(), id);
		return retrieveAllTasks();
	}
	
	public List<Task> deleteTask(long id) {
		jdbcTemplate.update(DELETE_TASK_QUERY, id);
		return retrieveAllTasks();
	}
}
