package com.lambda.expression;

import com.functional.interfaces.DefaultInterface;

public class DefaultInterfaceMain implements DefaultInterface{

	public void m1() {
		System.out.println("Implementation class");
	}
	public static void main(String[] args) {
		DefaultInterfaceMain main = new DefaultInterfaceMain();
		main.m1();
		System.out.println(main.m2());
	}
}
