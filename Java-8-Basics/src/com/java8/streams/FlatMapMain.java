package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.lambda.model.IntDemoPerson;

public class FlatMapMain {

	public static void main(String[] args) {
		//primitive int multi dimension to flatmap
		int[][] data= {{1,2},{3,4},{5,6}};
		IntStream i1 = Arrays.stream(data).flatMapToInt(f->Arrays.stream(f));
		i1.forEach(System.out::println);
		//user defined object to flatmap
		int[] i2 = {12,14};
		int[] i3 = {15,16};
		IntDemoPerson idp1 = new IntDemoPerson("Kumar", i2);
		IntDemoPerson idp2 = new IntDemoPerson("Ashok", i3);
		List<IntDemoPerson> list = Arrays.asList(idp1,idp2);
		IntStream is = list.stream().flatMapToInt(f-> Arrays.stream(f.getLuckyNum()));
		is.forEach(System.out::print);
		 // Creating a List of Strings
        List<String> lists = Arrays.asList("5.6", "7.4", "4",
                                          "1", "2.3");
  
        // Using Stream flatMap(Function mapper)
        lists.stream().flatMap(num -> Stream.of(num)).
                         forEach(System.out::println);
	}
}
