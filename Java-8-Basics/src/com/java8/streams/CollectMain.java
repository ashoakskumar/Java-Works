package com.java8.streams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.lambda.model.Item;

public class CollectMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Concatenating List of Strings
		List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");
		StringBuilder sb = vowels.stream().collect(StringBuilder::new,(x,y)->x.append(y),(a,b)->a.append(",").append(b));
		System.out.println(sb.toString());
		StringBuilder result1 = vowels.parallelStream().collect(StringBuilder::new, (x, y) -> x.append(y),
				(a, b) -> a.append(",").append(b));
		System.out.println(result1.toString());
		/*
		 * o/p - aeiou - we have a sequential stream of elements. So they are processed one by one and there is only one instance of StringBuilder. There is no use of the combiner function.
		 * a,e,i,o,u - So, the elements are processed parallelly and there are multiple instances of StringBuilder that are being merged by the combiner function. 
		 */
		StringBuilder finalResult = vowels.parallelStream().collect(StringBuilder::new,StringBuilder::append,StringBuilder::append);
		System.out.println(finalResult.toString());
		//Stream collect to list
		Integer []array = {1,2,3,4,5,6,7,8,9};
		List<Integer> intList = Arrays.stream(array).filter(num->num%2==0).collect(Collectors.toList());
		System.out.println(intList);
		List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");
		    listWithDuplicates.stream().collect(Collectors.toMap(Function.identity(), String::length, (item, identicalItem) -> item));
		    System.out.println(listWithDuplicates);
		//Stream collect to Set
		Set<Integer> setList = Arrays.stream(array).filter(num->num%2==1).collect(Collectors.toSet());
		System.out.println(setList);
		//Stream collect to map
		Map<Integer,Integer> map = Arrays.stream(array).filter(num->num%2==1).collect(Collectors.toMap(Function.identity(), x->x));
		System.out.println(map);
		//Stream Collect to joining
		System.out.println(listWithDuplicates.stream().collect(Collectors.joining()));;
		System.out.println(listWithDuplicates.stream().collect(Collectors.joining(",")));
		System.out.println(listWithDuplicates.stream().collect(Collectors.joining(" ","PRE-","-POST")));
		//Stream Counting
		System.out.println(listWithDuplicates.stream().collect(Collectors.counting()));;
		//Stream Summarizing
		IntSummaryStatistics intSummaryStatistics = Arrays.stream(array).collect(Collectors.summarizingInt(i->i));
		System.out.println(intSummaryStatistics.getMax());
		//Average 
		System.out.println(Arrays.stream(array).collect(Collectors.averagingInt(i->i)));
		//Collect and then
		System.out.println(Arrays.stream(array).collect(Collectors.collectingAndThen(Collectors.averagingInt(i->i*2), s->s*s)));
		//Collect Summing
		System.out.println(Arrays.stream(array).collect(Collectors.summingInt(i->i)));
		//groupBY - this operation does the grouping of element on the basis of given key and returns the collector
		//list to grouping map
		List<String> items = Arrays.asList("apple", "apple", "banana",
                "apple", "orange", "banana", "papaya");
		Map<String,Long> itemMap = items.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		itemMap.entrySet().stream().forEach(System.out::println);
		//list to grouping map with sorting
		Map<String,Long> finalMap = new LinkedHashMap<>();
		itemMap.entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
		System.out.println(finalMap);
		//groupby list of user defined objects
		 List<Item> itemss = Arrays.asList(
	                new Item("apple", 10, new BigDecimal("9.99")),
	                new Item("banana", 20, new BigDecimal("19.99")),
	                new Item("orang", 10, new BigDecimal("29.99")),
	                new Item("watermelon", 10, new BigDecimal("29.99")),
	                new Item("papaya", 20, new BigDecimal("9.99")),
	                new Item("apple", 10, new BigDecimal("9.99")),
	                new Item("banana", 10, new BigDecimal("19.99")),
	                new Item("apple", 20, new BigDecimal("9.99"))
	        );
		 Map<String,Long> countMap = itemss.stream().collect(Collectors.groupingBy(Item::getName,Collectors.counting()));
		 System.out.println(countMap);
		 
		 Map<String,Integer> sum = itemss.stream().collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));
		 System.out.println(sum);
		 
		  Map<BigDecimal, List<Item>> groupByPriceMap = 
				  itemss.stream().collect(Collectors.groupingBy(Item::getPrice));

		        System.out.println(groupByPriceMap);
		//group with mapping
		 Map<BigDecimal,Set<String>> result = itemss.stream().collect(Collectors.groupingBy(Item::getPrice,Collectors.mapping(Item::getName, Collectors.toSet())));
		 System.out.println(result);
		 Map<BigDecimal,String> result11 = itemss.stream().collect(Collectors.groupingBy(Item::getPrice,Collectors.mapping(Item::getName, Collectors.joining(","))));
		 System.out.println(result11);
		 //Grouping with partition -partitioningBy is a method that partitions the element of stream always in two part
		 Map<Boolean, List<Item>> partMap = itemss.stream().collect(Collectors.partitioningBy(item->item.getPrice().compareTo(new BigDecimal(15)) == 1));
		 System.out.println(partMap);
		 //output - {false=[Item [name=apple, qty=10, price=9.99], Item [name=papaya, qty=20, price=9.99], Item [name=apple, qty=10, price=9.99], Item [name=apple, qty=20, price=9.99]], true=[Item [name=banana, qty=20, price=19.99], Item [name=orang, qty=10, price=29.99], Item [name=watermelon, qty=10, price=29.99], Item [name=banana, qty=10, price=19.99]]}
		 //Grouping with reducing - educing is used to reduce the stream element with the help of Comparator and BinaryOperator
		 Comparator<Item> priceComparator = Comparator.comparing(Item::getPrice);
		 Map<String,Optional<Item>> reduceMap = itemss.stream().collect(Collectors.groupingBy(Item::getName, Collectors.reducing(BinaryOperator.minBy(priceComparator))));
		 System.out.println(reduceMap);
		 
		 
		 
	}
}
