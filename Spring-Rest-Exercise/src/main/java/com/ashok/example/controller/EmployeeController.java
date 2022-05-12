package com.ashok.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.example.model.Employee;
import com.ashok.example.service.EmployeeService;

@RestController()
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	@PostMapping(path = {"save/employee"})
	public ResponseEntity<Employee> save(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(service.save(employee),HttpStatus.OK);
	}
	@GetMapping(path={"/get/employee/{id}"})
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id) {
		return new ResponseEntity<Employee>(service.getEmployeeById(id),HttpStatus.OK);
	}
	//wild card - suffix
	@PostMapping(path = {"wildcard/save/employee/**"})
	public ResponseEntity<Employee> savefromWildCard(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(service.save(employee),HttpStatus.OK);
	}
	//wild card - preffix
	@PostMapping(path = {"*/wildcard/prefix/save/employee"})
	public ResponseEntity<Employee> savefromWildCardSuffix(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(service.save(employee),HttpStatus.OK);
	}
	//multi param
	@GetMapping(path={"/get/employee/by/{id}","/get/{id}/employee"})
	public ResponseEntity<Employee> getEmployeeMultiPath(@PathVariable("id") Integer id) {
		return new ResponseEntity<Employee>(service.getEmployeeById(id),HttpStatus.OK);
	}
	//value path
	@GetMapping(value = {"/get/employees/{id}"})
	public ResponseEntity<Employee> getEmployeeIdBYValue(@PathVariable("id") Integer id) {
		return new ResponseEntity<Employee>(service.getEmployeeById(id),HttpStatus.OK);
	}
	//header param or query param
	@GetMapping(value= {"/get/employees/param"})
	public ResponseEntity<Employee> getEmployeeByParam(@RequestParam(value = "id") Integer id) {
		return new ResponseEntity<Employee>(service.getEmployeeById(id),HttpStatus.OK);
	}
	//header param with out value attribute
	@GetMapping(value= {"/get/employee/param/notvalue"})
	public ResponseEntity<Employee> getEmployeeWithoutValue(@RequestParam Integer id) {
		return new ResponseEntity<Employee>(service.getEmployeeById(id),HttpStatus.OK);
	}
	//header param with optional
	@GetMapping(path = {"/get/employee/param/optional"})
	public ResponseEntity<Employee> getEmployeeOptional(@RequestParam(value = "id") Integer id,@RequestParam(value = "name",required = false) String name) {
		return new ResponseEntity<Employee>(service.getEmployeeById(id),HttpStatus.OK);
	}
	//header param with default
		@GetMapping(path = {"/get/employee/param/default"})
		public ResponseEntity<Employee> getEmployeeDefault(@RequestParam(value = "id",defaultValue = "1") Integer id,@RequestParam(value = "name",required = false) String name) {
			return new ResponseEntity<Employee>(service.getEmployeeById(id),HttpStatus.OK);
		}
	//header param with specific value to call the controller method.
		@GetMapping(path = {"/get/employee/param/value"},params = {"id=2"})
		public ResponseEntity<Employee> getEmployeevalue(@RequestParam(value = "id",defaultValue = "1") Integer id,@RequestParam(value = "name",required = false) String name) {
			return new ResponseEntity<Employee>(service.getEmployeeById(id),HttpStatus.OK);
		}
	//dynamic url path param
		@GetMapping(path="/get/dynamic/param/employee/{id:[0-9]+}")
		public ResponseEntity<Employee> getEmployeeDynamic(@PathVariable Integer id){
			return new ResponseEntity<Employee>(service.getEmployeeById(id),HttpStatus.OK);
		}
	//get mapping with headers , here request made from the client(postman or ui) request header should match
		@GetMapping(path="/get/header/param/employee/{id:[0-9]+}",headers = {"content-type=application/json"})
		public ResponseEntity<Employee> getEmployeeHeader(@PathVariable Integer id,@RequestHeader(value = "Content-Type") String header){
			System.out.println(header);
			return new ResponseEntity<Employee>(service.getEmployeeById(id),HttpStatus.OK);
		}
		//post mapping with consumes & produces
		@PostMapping(path = "/post/employee/consume/",headers = {"content-type=application/json"},produces = MediaType.APPLICATION_JSON_VALUE,consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
		public ResponseEntity<Employee> postEmpl(@RequestBody Employee employee,@RequestHeader(value = "Content-Type") String header){
			System.out.println(header);
			return new ResponseEntity<Employee>(service.save(employee),HttpStatus.OK);
		}
		@PutMapping(path="/put/employee")
		public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
			return new ResponseEntity<Employee>(service.editSave(employee),HttpStatus.OK);
		}
		@PatchMapping(path="/patch/employee")
		public ResponseEntity<Employee> patchUpdateEmployee(@RequestBody Employee employee) {
			return new ResponseEntity<Employee>(service.patchSave(employee),HttpStatus.OK);
		}
		@DeleteMapping(path="/delete/employee")
		public ResponseEntity<String> deleteEmployee(@RequestBody Employee employee) {
			service.delete(employee);
			return new ResponseEntity<String>("Employee got deleted",HttpStatus.OK);
		}	
}
