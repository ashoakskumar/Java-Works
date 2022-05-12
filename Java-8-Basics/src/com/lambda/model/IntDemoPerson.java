package com.lambda.model;

import java.util.Arrays;

public class IntDemoPerson {

	private String name;
	private int[] luckyNum;
	
	public IntDemoPerson(String name, int[] luckyNum) {
		super();
		this.name = name;
		this.luckyNum = luckyNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getLuckyNum() {
		return luckyNum;
	}
	public void setLuckyNum(int[] luckyNum) {
		this.luckyNum = luckyNum;
	}
	@Override
	public String toString() {
		return "IntDemoPerson [name=" + name + ", luckyNum=" + Arrays.toString(luckyNum) + "]";
	}
	
	
}
