package com.java8.streams;

import java.util.Random;
import java.util.stream.Stream;

public class GenerateMain {

	public static void main(String[] args) {
		Stream.generate(()->new Random().nextInt(10)).limit(5).forEach(System.out::println);
	}
}
