package com.ashok.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ashok.example.dao.IEmployeeDAO;
import com.ashok.example.model.Employee;
import com.ctc.wstx.util.StringUtil;
@Service
public class EmployeeService {

	@Autowired
	IEmployeeDAO dao;
	
	public Employee save(Employee emp) {
		return dao.save(emp);
	}
	public Employee getEmployeeById(Integer id) {
		return dao.findById(id).get();
	}
	public Employee editSave(Employee employee) {
		Employee emp = getEmployeeById(employee.getId());
		emp.setAge(employee.getAge());
		return dao.save(emp);
	}
	public Employee patchSave(Employee employee) {
		Employee emp = getEmployeeById(employee.getId());
		if(employee.getAge() > 0) {
			emp.setAge(employee.getAge());
		}	
		if(employee.getDob() != null) {
			emp.setDob(employee.getDob());
		}
		if(StringUtils.hasLength(employee.getEmail())) {
			emp.setEmail(employee.getEmail());
		}
		if(StringUtils.hasLength(employee.getName())) {
			emp.setName(employee.getName());
		}
		return dao.save(emp);
	}
	public void delete(Employee employee) {
		dao.delete(employee);
	}
}
