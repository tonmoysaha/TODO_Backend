package com.todo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.todo.model.HelloWorldBean;

import javassist.NotFoundException;

@RestController
@CrossOrigin("http://localhost:4200")
public class HomeController {

	@GetMapping("/basicAuth")
	public String getAuthentication() {
		return "success";
	}

}
