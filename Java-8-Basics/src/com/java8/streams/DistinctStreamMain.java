package com.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.lambda.model.Book;

public class DistinctStreamMain {

	private static<t> Predicate<t> distinctByKey(Function<? super t, ?> keyExtractor) {
		Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
	public static void main(String[] args) {
		//distinct with count
		Long l = Stream.of("AA","BB","BB","AA").distinct().count();
		System.out.println(l);//o/p - 2
		//distinct with string joining
		String s = Stream.of("AA","BB","BB","AA").distinct().collect(Collectors.joining(","));
		System.out.println(s);//o/p - AA,BB
		//distinct for user object
		List<Book> bookList = new ArrayList<>();
		bookList.add(new Book("Java Book",300));
		bookList.add(new Book("Java Book",300));
		bookList.add(new Book("Angular Book",300));
		bookList.stream().distinct().forEach(b->System.out.println(b.getName()));
		//o/p - Java Book,Angular Book
		
		//Distinct by property
		bookList.stream().filter(distinctByKey(b -> b.getName()))
        .forEach(b -> System.out.println(b.getName()+ "," + b.getPrice())); 
		//o/p - Java Book,Angular Book
	}
}
