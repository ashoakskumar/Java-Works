package com.lambda.expression;

import com.functional.interfaces.AddInterface;
import com.functional.interfaces.Sayable;

public class MethodReferenceMain {

	public MethodReferenceMain() {
		System.out.println("Hello! This is constructor method");
	}
	public Integer sum(Integer i1, Integer i2) {
		return i1+i2;
	}
	public static void saySomething() {
		System.out.println("Helllo This is static method");
	}
	public static void threadStatus() {
		System.out.println("Thread is running");
	}
	public void saySomethingInstance() {
		System.out.println("Helllo This is Instance method");
	}
	public static void main(String[] args) {
		MethodReferenceMain main = new MethodReferenceMain();
		AddInterface sum = main::sum;
		System.out.println(sum.add(10, 20));
		String s = "ashjok";
		
		Sayable says = MethodReferenceMain::saySomething;
		says.say();
		
		Thread t = new Thread(MethodReferenceMain::threadStatus);
		t.start();
		
		Sayable sayInstance = main::saySomethingInstance;
		sayInstance.say();
		
		Sayable sayConstructor = MethodReferenceMain::new;
		sayConstructor.say();
	}
}
