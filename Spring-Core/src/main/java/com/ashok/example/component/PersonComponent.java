package com.ashok.example.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashok.example.model.Person;

import lombok.Data;
@Data
@Component
public class PersonComponent {

	@Autowired
	Person person1;
	@Autowired
	Person person2;
}
