package com.java8.streams;

import java.util.stream.Stream;

public class SkipMain {
public static void main(String[] args) {
	Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9).skip(4);
	stream.forEach(System.out::println);
}
}
