package com.todo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.todo.model.HelloWorldBean;

import javassist.NotFoundException;

@RestController
@CrossOrigin("http://localhost:4200")
public class HelloWorldController {

	@GetMapping("/hello-world")
	public String getHelloWorld() {
		return "Hello world";
	}

	@GetMapping("/hello-world-bean")
	public HelloWorldBean getHelloWorldBean() {
		return new HelloWorldBean("Hello world, opi");
	}

	@GetMapping("/hello-world-bean/{name}")
	public HelloWorldBean getHelloWorldBean(@PathVariable(name = "name", required = false) String name)
			throws NotFoundException {
		if (name.equals("opi")) {
			return new HelloWorldBean("Hello world " + name);
		}
		throw new NotFoundException("Name Can Not Be null");
	}

}
