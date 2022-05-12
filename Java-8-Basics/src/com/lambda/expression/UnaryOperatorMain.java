package com.lambda.expression;

import java.util.function.UnaryOperator;

public class UnaryOperatorMain {

	public static void main(String[] args) {
		UnaryOperator<Integer> uo = (i1)-> i1*i1;
		System.out.println(uo.apply(10));
	}
	
}
