package com.java8.streams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.lambda.model.User;

public class MapMain {

	public static void main(String[] args) {
		//Map to list
			Map<Integer,String> map = new HashMap<>();
			map.put(1, "Ashok");
			map.put(2,"kumar");
			map.put(3, "manoj");
			List<User> usrList = map.entrySet().stream().map(val->new User(val.getKey(),val.getValue())).collect(Collectors.toList());
			usrList.stream().forEach(usr->System.out.println(usr.getName()));
			//output - Ashok,Kumar, manoj
			//add keys to sum value
			long sum = map.entrySet().stream().mapToInt(mp->mp.getKey()).sum();
			System.out.println(sum);//o/p 6
	}
}
