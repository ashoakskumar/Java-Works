package com.java8.streams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.lambda.model.User;

public class MaptoListMain {

	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(23, "Mahesh");
		map.put(10, "Suresh");
		map.put(26, "Dinesh");
		map.put(11, "Kamlesh");
		//value mapto list
		List<String> valueMap = map.values().stream().collect(Collectors.toList());
		valueMap.stream().forEach(System.out::println);
		//keymap to list
		List<Integer> keyMap = map.keySet().stream().collect(Collectors.toList());
		keyMap.stream().forEach(System.out::println);
		//entry set map to userdefined list object
		List<User> userlist = map.entrySet().stream().map(usr -> new User(usr.getKey(),usr.getValue())).collect(Collectors.toList());
		userlist.forEach(System.out::println);
	}
}
