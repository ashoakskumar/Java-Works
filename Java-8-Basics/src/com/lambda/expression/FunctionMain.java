package com.lambda.expression;

import java.util.function.Function;

import com.lambda.model.Student;

public class FunctionMain {

	static Function<Student,String> f2 =  student -> {
		int totalMarks = student.getTotalMarks();
		String grade = "";
		if(totalMarks >= 80) {
			grade = "Distinction";
		} else if(totalMarks>= 60 && totalMarks < 80) {
			grade = "First Class";
		} else if(totalMarks>= 35 && totalMarks < 60) {
			grade = "Second Class";
		} else {
			grade = "Fail";
		}
		return  student.getName() + ":"  +grade;		
	};
	static Function<String,String> f3 = input -> input.toUpperCase();
	public static void main(String[] args) {
		String s="ashok";
		Function<String,String> f1 = input -> input.toUpperCase();
		String upperCase = f1.apply(s);
		System.out.println(upperCase);
		
//		Function<Student,String> f2 =  student -> {
//			int totalMarks = student.getTotalMarks();
//			String grade = "";
//			if(totalMarks >= 80) {
//				grade = "Distinction";
//			} else if(totalMarks>= 60 && totalMarks < 80) {
//				grade = "First Class";
//			} else if(totalMarks>= 35 && totalMarks < 60) {
//				grade = "Second Class";
//			} else {
//				grade = "Fail";
//			}
//			return  student.getName() + ":"  +grade;		
//		};
		
		Student[] student = {new Student("Ashok",60),new Student("Kumar",20)};
		for(Student std : student)
			System.out.println(f3.compose(f2).apply(std));
		
	}
}
