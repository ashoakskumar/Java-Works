package com.lambda.expression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.lambda.model.Employee;

public class EmployeeMain {
	public static void main(String[] args) {

		List<Employee> eList = new ArrayList<>();
		eList.add(new Employee(1, "Ashok"));
		eList.add(new Employee(2, "kumar"));
		eList.add(new Employee(3, "Jp"));
		eList.add(new Employee(4, "selvam"));
		eList.add(new Employee(5, "peter"));
		
		Comparator<Employee> comparator = (e1,e2)-> e1.geteName().compareTo(e2.geteName());
		
		Collections.sort(eList,comparator);
		System.out.println(eList);
	}
}
