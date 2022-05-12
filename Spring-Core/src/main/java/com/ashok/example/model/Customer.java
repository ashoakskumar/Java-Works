package com.ashok.example.model;

import lombok.Data;

@Data
public class Customer {

	String name;
	public Customer() {
		System.out.println("Customer bean instance is created");
	}
}
