package com.ashok.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ashok.example.model.Address;
import com.ashok.example.model.Person;
@Configuration
public class PersonConfig {

	@Bean
	public Person person1(Address address) {
		Person person = new Person();
		person.setAge(10);
		person.setName("Ashok");
		person.setAddress(address);
		return person;
	}
	@Bean
	public Person person2(Address address) {
		Person person = new Person();
		person.setAge(19);
		person.setName("Kumar");
		person.setAddress(address);
		return person;
	}
	@Bean
	public Address address() {
		return new Address("chennai");
	}
	@Bean("addr")
	public Address address1() {
		return new Address("vellore");
	}
}
