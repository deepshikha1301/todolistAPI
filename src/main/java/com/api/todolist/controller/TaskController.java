package com.api.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.todolist.model.Task;
import com.api.todolist.service.TaskService;

@RestController
@RequestMapping("/v1")
public class TaskController {
	
	@Autowired
	TaskService taskService;

	@GetMapping("/tasks")
	public List<Task> getAllTasks(){
		return taskService.getAllTasks();
	}
	
	@DeleteMapping("/tasks/{id}")
	public List<Task>  deleteTaskById(@PathVariable long id) {
		return taskService.deleteTaskById(id);
	}
	
	@PutMapping("/tasks/{id}")
	public List<Task> updateTask(@PathVariable long id, @RequestBody Task task) {
		return taskService.updateTask(id, task);
	}
	
	@PostMapping("/tasks")
	public List<Task> createTask(@RequestBody Task task) {
		return taskService.createTask(task);
	}
}
