package com.ashok.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.ashok.example.model.Customer;
import com.ashok.example.model.Employee;

@Configuration
@ComponentScan(basePackages = {"com.ashok.example.model"})
public class LazyConfig {

	@Bean
	public Employee getEmployee() {
		return new Employee();
	}
	@Bean
	@Lazy
	public Customer getCustomer() {
		return new Customer();
	}
}
