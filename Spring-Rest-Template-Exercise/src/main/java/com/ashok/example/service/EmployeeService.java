package com.ashok.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashok.example.dao.EmployeeDAO;
import com.ashok.example.model.Employee;
@Service
public class EmployeeService {

	@Autowired
	EmployeeDAO dao;
	
	public Employee save(Employee employee) {
		return dao.save(employee);
	}
	
	public Employee getEmployeeById(Integer id) {
		return dao.findById(id).get();
	}
	
	public List<Employee> getAllEmployee() {
		return dao.findAll();
	}
}
