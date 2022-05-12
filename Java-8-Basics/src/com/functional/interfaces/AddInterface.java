package com.functional.interfaces;
@FunctionalInterface
public interface AddInterface {

	public Integer add(Integer i1 , Integer i2);
	//public Integer sub(Integer i1 , Integer i2);
	public static void  method1() {
		System.out.println("This is static method");
	}
	public default void method2() {
		System.out.println("This is default method");
	}
}
