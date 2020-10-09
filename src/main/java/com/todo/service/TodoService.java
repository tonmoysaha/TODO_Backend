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
	
	public List<Todo> getAll(){
		return todos;
		
	}

}
