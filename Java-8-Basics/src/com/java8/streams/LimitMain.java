package com.java8.streams;

import java.util.stream.Stream;

public class LimitMain {

	public static void main(String[] args) {
		Stream.of("a","b","c").limit(2).forEach(System.out::println);
	}//output - a,b
}
