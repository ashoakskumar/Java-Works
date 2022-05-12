package com.java8.streams;

import java.util.Arrays;

public class ReduceMain {

	public static void main(String[] args) {
		int[] array= {12,3,44,5,6,7,87,9,06,5};
		int sum = Arrays.stream(array).reduce((x, y) -> x+y).getAsInt();
		System.out.println(sum);
		int sum1 = Arrays.stream(array).reduce(Integer::sum).getAsInt();
		System.out.println(sum1);
		//o/p - 184
		//Stream.reduce() with Identity and Accumulator
		int startVal = 100;
		int sum3 = Arrays.stream(array).reduce(startVal,Integer::sum);
		System.out.println(sum3);
		
	}
}
