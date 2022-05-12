package com.ashok.example.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ashok.example.model.Employee;
import com.ashok.example.service.EmployeeService;

@RestController
@RequestMapping("/http/status/code")
public class HttpStatusController {

	@Autowired
	EmployeeService service;
	
	//Example for http status code - 201 - created resource
	@PostMapping(value= {"/post/201"})
	public ResponseEntity<Employee> save201(@RequestBody Employee employee){
		Employee empl= service.save(employee);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(empl.getId()).toUri();
		return ResponseEntity.created(location).body(empl);
	}
	
}
