package com.lambda.expression;

import java.util.function.Predicate;

public class PredicateMain {

	public static void main(String[] args) {
		Integer []numbers = {89,99,70,60,10,20,35,65,33,99};
		Predicate<Integer> divisor = (num)-> num %2 ==0;
		Predicate<Integer> greater = (num)-> num > 50;
		for(Integer number : numbers) {
//			if(divisor.test(number)) {
//				System.out.println("Divisor: "+ number);
//			}
//			if(greater.test(number)) {
//				System.out.println("Greater: " + number);
//			}
//			if(divisor.negate().test(number)) {
//				System.out.println("Divisor Negate: "+ number);
//			}
//			if(divisor.and(greater).test(number)) {
//				System.out.println("Divisor And Greater: "+ number);
//			}
			if(divisor.or(greater).test(number)) {
				System.out.println("Divisor Or Greater: "+ number);
			}
		}
	}
}
