package com.example.SimpleSprintDemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping("/hello")
	public ResponseEntity<Person> hello() {
		String hello = "Hello World";
		Person p = new Person("Mohammed Arshad", 26);
		return ResponseEntity.ok(p);
	}
}
