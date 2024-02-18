package com.api.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.todolist.model.Task;
import com.api.todolist.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepository;
	
	public List<Task> getAllTasks(){
		return taskRepository.retrieveAllTasks();
	}

	public List<Task> deleteTaskById(long id) {
		return taskRepository.deleteTask(id);
	}
	
	public List<Task> updateTask(long id, Task task) {
		return taskRepository.updateTask(id, task);
	}
	
	public List<Task> createTask(Task task) {
		return taskRepository.addTask(task);
		
	}
}
