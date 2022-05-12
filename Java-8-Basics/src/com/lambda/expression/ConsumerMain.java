package com.lambda.expression;

import java.util.function.Consumer;

public class ConsumerMain {

	public static void main(String[] args) {
		char []character = {'a','b','b','d'};
		Consumer<Character> chars = (c)-> System.out.println(c);
		for(char c:character) {
			chars.accept(c);
		}
	}
}
