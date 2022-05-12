package com.lambda.expression;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.functional.interfaces.AddInterface;

public class FunctionalInterfaceExample1 {
	public static void main(String[] args) {
		AddInterface ai = (i1,i2) -> i1+i2;
		System.out.println(ai.add(10, 10));
		ai.method2();
		AddInterface.method1();
		//Thread with functional interface
		Runnable r = () -> {
			for(int i=0;i<5;i++) {
				System.out.println("child thread");
			}
		};
		Thread t = new Thread(r);
		t.start();
		for(int i=0;i<5;i++) {
			System.out.println("main thread");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		List<Integer> l1 = new ArrayList<>();
		l1.add(20);
		l1.add(10);
		l1.add(80);
		l1.add(60);
		l1.add(30);
		Comparator<Integer> comparator = (Integer i1,Integer i2)-> i1>i2 ? 1 : i1<i2 ? -1 : 0;
		Collections.sort(l1,comparator);
		System.out.println(l1);
	}
}
