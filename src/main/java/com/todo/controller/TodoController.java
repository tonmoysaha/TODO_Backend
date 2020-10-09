package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public List<Todo> getAllTodos(@PathVariable("username") String name){
		return todoService.getAll();
		
	}
	
	@DeleteMapping("{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable("username") String name, @PathVariable("id") Long id){
		Todo deleteTodo = this.todoService.deleteTodo(id);
		if (deleteTodo != null) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable("username") String name, @PathVariable("id") Long id, @RequestBody Todo todo){
		Todo updateTodo = this.todoService.save(todo);
		return new ResponseEntity<Todo>(updateTodo, HttpStatus.OK);
		
	}

}
