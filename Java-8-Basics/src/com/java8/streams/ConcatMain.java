package com.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.lambda.model.Student;

public class ConcatMain {

	public static void main(String[] args) {
		//stream concat
		Stream<String> alpha = Stream.concat(Stream.of("a","b"), Stream.of("c","d"));
		alpha.forEach(System.out::println);
		//output - a,b,c,d
		//stream contact - list
		List<Student> list1 = new ArrayList<>();
		list1.add(new Student("Ashok",30));
		List<Student> list2 = new ArrayList<>();
		list2.add(new Student("Kumar",20));
		List<Student> concat = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
		concat.forEach(list -> System.out.println(list.getName()));//output - Ashok,kumar
		//Array concat
		Student s1[] = new Student[1];
		Student s2[] = new Student[1];
		s1[0] = new Student("Ashok",30);
		s2[0] = new Student("Kumar",20);
		Student[] s = Stream.concat(Stream.of(s1), Stream.of(s2)).toArray(Student[]::new);
		for(Student std:s) {
			System.out.println(std.getName());
		}//output - Ashok,kumar
	}
}
