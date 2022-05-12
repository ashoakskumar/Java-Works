package com.java8.streams;

import java.util.stream.Stream;

public class PeekMain {

	public static void main(String[] args) {
		Stream.of(1,2,43,4,5,6,7).filter(i->i>5).peek(System.out::println).forEach(i->System.out.println("i: "+i));
	}
}
