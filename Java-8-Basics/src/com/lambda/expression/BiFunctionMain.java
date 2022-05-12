package com.lambda.expression;

import java.util.function.BiFunction;

public class BiFunctionMain {
static BiFunction<Integer,Integer,Integer> bi = (i1,i2)->i1+i2;
public static void main(String[] args) {
	System.out.println(bi.apply(10, 10));
}
}
