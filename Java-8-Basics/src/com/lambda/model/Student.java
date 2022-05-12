package com.lambda.model;

public class Student {

	String name;
	int totalMarks;
	public Student(String name,int marks) {
		this.name = name;
		this.totalMarks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	
}
