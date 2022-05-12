package com.ashok.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ashok.example.model.HelloMsg;
@Configuration
@PropertySource("classpath:messages.properties")
public class HelloMsgConfig {

	@Value("${motd}")
	private String message;
	@Bean(name="message",initMethod = "init", destroyMethod = "destroy")
	public HelloMsg msg() {
		return new HelloMsg(message);
	}
}
