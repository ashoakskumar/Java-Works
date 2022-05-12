package com.lambda.expression;

interface example{
	public abstract void method1();
	public abstract void method2();
}
public class AnonymousInnerClass {

	public static void main(String[] args) throws InterruptedException {
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<5;i++) {
					System.out.println("child thread");
				}
			}
		};
		Thread t = new Thread(r);
		t.start();
		for(int i=0;i<5;i++) {
			System.out.println("parent thread");
			Thread.sleep(100);
		}
		example e = new example() {
			
			@Override
			public void method2() {
				System.out.println("THis is method 1");
				
			}
			
			@Override
			public void method1() {
				System.out.println("THis is method 2");
				
			}
		};
		e.method1();
		e.method2();
	}
}
