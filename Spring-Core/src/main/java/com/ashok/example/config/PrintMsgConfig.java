package com.ashok.example.config;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ashok.example.model.PrintMsg;

@Configuration
@PropertySource({"classpath:messages.properties","classpath:messages2.properties"})
public class PrintMsgConfig {

	@Value("${motds:default msg}")
	String message;
	@Value("${listOfValues}")
	String []listOfValue;
	@Value("static value")
	String staticValue;
	@Value("#{${valuesMap}}")
	Map<String,Integer> valueMap;
	@Value("#{${valuesMap}.key1}")
	private Integer valuesMapKey1;
	@Value("${motd2}")
	String msg2;
	@Bean 
	public PrintMsg print() {
		System.out.println(Arrays.asList(listOfValue));
		System.out.println(staticValue);
		System.out.println(valueMap);
		System.out.println(valuesMapKey1);
		System.out.println(msg2);
		return new PrintMsg(message);
	}
}
