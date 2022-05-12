package com.ashok.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class HelloMsg {

	private String message;
	
	public void init() {
		System.out.println("init method called");
	}
	public void destroy() {
		System.out.println("destroy method called");
	}
}
