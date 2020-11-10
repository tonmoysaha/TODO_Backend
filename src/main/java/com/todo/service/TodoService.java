package com.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.model.Todo;
import com.todo.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
	

	public List<Todo> getAll() {
		return todoRepository.findAll();

	}

	public void deleteTodo(Long id) {

		Todo todo = this.todoRepository.findById(id).orElse(null);
		if (todo != null) {
			this.todoRepository.delete(todo);
		}

	}

	public Todo save(Todo todo) {

		return this.todoRepository.save(todo);

	}

}
