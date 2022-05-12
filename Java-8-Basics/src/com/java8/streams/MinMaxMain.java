package com.java8.streams;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.lambda.model.Student;

public class MinMaxMain {

	public static void main(String[] args) {
		//min example
		Optional<Integer> min = Stream.of(30,20,90,70,40,20).min(Comparator.comparing(Integer::intValue));
		if(min.isPresent())System.out.println(min.get());
		//output - 20
		//Max example
		Optional<Integer> max = Stream.of(30,20,90,70,40,20).max(Comparator.comparing(Integer::intValue));
		if(max.isPresent())System.out.println(max.get());
		//output - 90
		Comparator<String> nameComparator = Comparator.comparing(String::valueOf);
		Optional<String> minName = Stream.of("Mohit", "Nilesh", "Shankar", "Brajesh").min(nameComparator);
		if(minName.isPresent()) {
			System.out.println(minName.get());
		}//output - Brajesh
		Optional<String> maxName = Stream.of("Mohit", "Nilesh", "Shankar", "Brajesh").max(nameComparator);
		if(maxName.isPresent()) {
			System.out.println(maxName.get());
		}//output - Shankar
		//Min Max using reduce method
		Optional<String> minReduceName = Stream.of("Mohit", "Nilesh", "Shankar", "Brajesh").reduce((s1,s2)->{
			if(s1.compareTo(s2)<=0) {
				return s1;
			} return s2;
		});
		if(minReduceName.isPresent()) {
			System.out.println(minReduceName.get());
		}//output - Brajesh
		Optional<String> maxReduceName = Stream.of("Mohit", "Nilesh", "Shankar", "Brajesh").reduce((s1,s2)->{
			if(s1.compareTo(s2)>=0) {
				return s1;
			} return s2;
		});
		if(maxReduceName.isPresent()) {
			System.out.println(maxReduceName.get());
		}//output - Shankar
		//min and max using user defined object
		Optional<Student> maxObject = Stream.of(new Student("Ashok", 30),new Student("kumar", 10)).max(Comparator.comparing(Student::getName));
		if(maxObject.isPresent()) {
			System.out.println(maxObject.get().getName());
		}//output - kumar
		Optional<Student> minObject = Stream.of(new Student("Ashok", 30),new Student("kumar", 10)).min(Comparator.comparing(Student::getName));
		if(minObject.isPresent()) {
			System.out.println(minObject.get().getName());
		}//output - ashok
		//Min & Max using date
		LocalDate date = LocalDate.parse("2020-05-05");
		List<LocalDate> dateList = new ArrayList<>();
		dateList.add(date.plus(15,ChronoUnit.DAYS));
		dateList.add(date.minus(10,ChronoUnit.DAYS));
		dateList.add(date);
		dateList.stream().min(Comparator.comparing(LocalDate::toEpochDay)).ifPresent(dt->System.out.println(dt));
		dateList.stream().max(Comparator.comparing(LocalDate::toEpochDay)).ifPresent(dt->System.out.println(dt));
		//o/p - 2020-04-25,2020-05-20
		
	}
}
