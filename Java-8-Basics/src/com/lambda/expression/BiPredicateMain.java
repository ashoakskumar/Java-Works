package com.lambda.expression;

import java.util.function.BiPredicate;

public class BiPredicateMain {

	public static void main(String[] args) {
		BiPredicate<Integer,Integer> bi = (i1,i2)->(i1+i2)%2==0;
		System.out.println(bi.test(10, 10));
	}
}
