package com.lambda.expression;

import java.util.function.Supplier;

public class SupplierMain {
	static Supplier<String> s1 = ()->{
		String otp = "";
		for(int i=0;i<6;i++) {
			otp=otp+(int)(Math.random()*10);
		}
		return otp;
	};

	public static void main(String[] args) {
		System.out.println(s1.get());
	}
}
