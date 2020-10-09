package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.model.Todo;
import com.todo.service.TodoService;

@RestController
@RequestMapping("/users")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping("{username}/todos")
	public List<Todo> getAllTodos(String name){
		return todoService.getAll();
		
	}

}
