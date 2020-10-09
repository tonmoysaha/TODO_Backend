package com.todo.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.todo.model.Todo;

@Service
public class TodoService {

	private static List<Todo> todos = new LinkedList<>();
	private static int todoIDCount = 0;

	static {
		todos.add(new Todo((long) ++todoIDCount, "opi", "Learn to dance", new Date(), false));
		todos.add(new Todo((long) ++todoIDCount, "opi", "Learn about Microservice", new Date(), false));
		todos.add(new Todo((long) ++todoIDCount, "opi", "Learn about Angular", new Date(), false));
	}

	public List<Todo> getAll() {
		return todos;

	}

	public Todo deleteTodo(long id) {

		Todo todo = this.findById(id);
		if (todos.remove(todo)) {
			return todo;
		}

		return null;

	}

	private Todo findById(long id) {
		// TODO Auto-generated method stub
		Todo todo2 = todos.stream().filter(todo -> todo.getId() == id).findFirst().get();
		
		if (todo2 != null) {
			return todo2;
		}
		return null;
	}
	
	public Todo save(Todo todo) {
		Todo saveTodo = this.findById(todo.getId());
		if (saveTodo == null) {
			todo.setId((long) ++todoIDCount);
			todos.add(todo);
		} else {
			this.deleteTodo(todo.getId());
			todos.add(todo);
		}
		return todo;
		
	}

}
