package com.ashok.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.example.model.Employee;
import com.ashok.example.service.EmployeeService;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@PostMapping(value = {"/post/employee"})
	public ResponseEntity<Employee> save(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(service.save(employee),HttpStatus.OK);
	}
	
	@GetMapping(path = {"/get/employee/{id}"})
	public ResponseEntity<Employee> getById(@PathVariable("id") Integer id) {
		return new ResponseEntity<Employee>(service.getEmployeeById(id),HttpStatus.OK);
	}
	
	@GetMapping(path = {"/get/all/employee"})
	public ResponseEntity<List<Employee>> getAll() {
		return new ResponseEntity<List<Employee>>(service.getAllEmployee(),HttpStatus.OK);
	}
}
