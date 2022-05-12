package com.ashok.example.model;

import lombok.Data;

@Data
public class Employee {

	String name;
	public Employee() {
		System.out.println("Employee bean instance is created");
	}
}
