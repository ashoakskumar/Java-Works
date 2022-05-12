package com.lambda.expression;

import java.util.function.DoubleToIntFunction;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;

public class BiConsumer {

	public static void main(String[] args) {
		java.util.function.BiConsumer<Integer, Integer> bi = (i1,i2)->System.out.println(i1+i2);
		bi.accept(10, 10);
		IntFunction<Integer> inf = (i1)->i1;
		System.out.println(inf.apply(10));
		DoubleToIntFunction dtf = (d1)-> (int)d1;
		System.out.println(dtf.applyAsInt(10.334));
		
	}
}
