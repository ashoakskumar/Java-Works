package com.functional.interfaces;

public interface DefaultInterface {

	public default void m1() {
		System.out.println("This is default interface method 1");
	};
	public default String m2() {
		return "THis is default interface method 2";
	};
	
}
