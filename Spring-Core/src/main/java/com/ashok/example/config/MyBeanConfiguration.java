package com.ashok.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ashok.example.model.MyBean;
import com.ashok.example.model.MyBean2;

@Configuration
public class MyBeanConfiguration {

	@Bean
	public MyBean bean() {
		return new MyBean();
	}
	@Bean
	public MyBean2 bean2(MyBean bean) {
		System.out.println("Injecting bean A through contructor");
		return new MyBean2(bean);
	}
}
