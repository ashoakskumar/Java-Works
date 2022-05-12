package com.java8.streams;

import java.util.stream.Stream;

import com.lambda.model.Student;

public class StreamsOfMain {
public static void main(String[] args) {
	Stream<String> alpha = Stream.of("A","B","C","D");
	alpha.forEach(System.out::println);
	Stream<String> alpha1 = Stream.of("A","B","C","D");
	alpha1.forEachOrdered(e->System.out.println(e));
	Stream<Student> stream = Stream.of(new Student("Ashok", 30),new Student("kumar", 60));
	stream.forEachOrdered(e->System.out.println(e.getName()));
}
}
