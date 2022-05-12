package com.lambda.expression;

import com.functional.interfaces.DiamondInterface;
import com.functional.interfaces.DiamondInterface2;

public class DiamondMain implements DiamondInterface,DiamondInterface2{

	public void m1() {
		DiamondInterface.super.m1();
	}
	public static void main(String[] args) {
		DiamondMain main = new DiamondMain();
		main.m1();
	}
}
