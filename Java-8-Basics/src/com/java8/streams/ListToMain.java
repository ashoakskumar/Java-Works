package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.lambda.model.User;

public class ListToMain {

	public static void main(String[] args) {
		//list of string to map<string,string>
		List<String> strList = Arrays.asList("kumar","Ashok");
		Map<String,String> strMap = strList.stream().collect(Collectors.toMap(Function.identity(), i->i));
		System.out.println(strMap);
		//list of user defined object to map<Integer,String>
		List<User> userList = Arrays.asList(new User(1,"Ashok"),new User(2,"Kumar"),new User(3,"Kumar2"));
		userList.stream().collect(Collectors.toMap(User::getId, User::getName));
		userList.forEach(System.out::println);
		//List to Map with Key Mapper, Value Mapper and Merge Function
		Map<Integer,String> mapper = userList.stream().collect(Collectors.toMap(User::getId, User::getName,(x,y)->x+","+y));
		mapper.entrySet().forEach(System.out::println);
		//output - 1=Ashok,Kumar2
		//2=Kumar
	}
}
