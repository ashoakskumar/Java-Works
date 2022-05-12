package com.java8.streams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.lambda.model.Item;

public class MatchMain {

	public static void main(String[] args) {
		List<Item> itemList = Arrays.asList(new Item("apple", 1, new BigDecimal(100)),
				new Item("orange", 3, new BigDecimal(300)),
				new Item("pineapple", 4, new BigDecimal(1900)));
		Predicate<Item> pricePredicate = item -> item.getQty() > 2;
		boolean b1 = itemList.stream().allMatch(pricePredicate);
		System.out.println(b1);
		boolean b2 = itemList.stream().noneMatch(pricePredicate);
		System.out.println(b2);
		boolean b3 = itemList.stream().anyMatch(pricePredicate);
		System.out.println(b3);
	}
}
