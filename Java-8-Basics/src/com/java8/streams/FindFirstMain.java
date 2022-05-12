package com.java8.streams;

import java.util.stream.Stream;

import com.lambda.model.Student;

public class FindFirstMain {

	public static void main(String[] args) {
		Stream.of(new Student("Ashok",40),new Student("kumar",90)).filter(std->std.getTotalMarks()>50).findFirst().ifPresent(std->System.out.println(std.getName()));;	
	}//output - kumar
}
