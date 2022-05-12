package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayStreamMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Example-1: In this example we will convert stream of string into array of
		 * string.
		 */
		List<String> stringLst= Arrays.asList("A","BB","C");
		String []strArr = stringLst.stream().toArray(String[]::new);
		for(String str : strArr) {
			System.out.println(str);
		} // output - A,B,C
		/*
		 * Example-2: In this example we will convert stream of string into array of
		 * string size using lambda expression.
		 */	
		strArr = stringLst.stream().toArray(size->new String[size]);
		for(String str : strArr) {
			System.out.println(str);
		}// output - A,B,C
		
		String in = stringLst.stream().reduce((str1,str2)->str1+","+str2).get();
		System.out.println(in);
	}
}
