package com.java8.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.lambda.model.Trainer;

public class SortMain {

	public static void main(String[] args) {
		List<Trainer> trainerList = new ArrayList<>();
		trainerList.add(new Trainer(1,20,"kumar"));
		trainerList.add(new Trainer(1,30,"Ashok"));
		trainerList.add(new Trainer(1,10,"manoj"));
		//default sort order
		trainerList.stream().sorted().forEach(t->System.out.println(t.getName()));
		//reverse sort order
		trainerList.stream().sorted(Comparator.reverseOrder()).forEach(t->System.out.println(t.getName()));
		//sort for specific keys
		trainerList.stream().sorted(Comparator.comparing(Trainer::getAge)).forEach(t->System.out.println(t.getName()));
		

	}
}
