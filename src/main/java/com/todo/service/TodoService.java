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

	public List<Todo> getAll(String name) {

		return todoRepository.findByUsername(name);

	}

	public boolean deleteTodo(String name, Long id) {

		Todo todo = this.todoRepository.findByUsernameAndId(name, id);
		if (todo != null) {
			this.todoRepository.delete(todo);
			return true;
		}
		return false;

	}

	public Todo save(String name, Long id, Todo todo) {
		if (id == null) {
			todo.setUsername(name);
			return this.todoRepository.save(todo);
		} else {
			todo.setId(id);
			todo.setUsername(name);
			return this.todoRepository.save(todo);
		}

	}

}
