package com.ashok.example;

import java.net.URI;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ashok.example.model.Employee;

@SpringBootApplication
public class SpringRestTemplateExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestTemplateExerciseApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	    return builder.build();
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
	    return args -> {
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.setContentType(MediaType.APPLICATION_JSON);
	    	URI uri = new URI("http://localhost:8080/api/post/employee");
	    	
	    	Employee emp = new Employee();
	    	emp.setCity("Chennai");
	    	emp.setName("kumar");
	    	
	    	HttpEntity<Employee> entity = new HttpEntity<>(emp,headers);
//	        Employee employee = restTemplate.postForObject(uri,entity, Employee.class);
	    	ResponseEntity<Employee> re = restTemplate.postForEntity(uri,entity, Employee.class);
	        //System.out.println(re.getBody());
//	        System.out.println(re.getStatusCode());
	        
	        String uriGet = "http://localhost:8080/api/get/employee/{id}";
	        Employee getEmp = restTemplate.getForObject(uriGet, Employee.class, 1);
	        //System.out.println(getEmp);
	        
	        String uriGetEntity = "http://localhost:8080/api/get/employee/{id}";
	        ResponseEntity<Employee> getEmpEntity = restTemplate.getForEntity(uriGetEntity, Employee.class, 1);
	        //System.out.println(getEmpEntity.getBody());
	        
	        String uriGetEntityAll = "http://localhost:8080/api/get/all/employee";
	        ResponseEntity<Employee[]> getEmpEntityList = restTemplate.getForEntity(uriGetEntityAll, Employee[].class, 1);
	        System.out.println(getEmpEntityList.getBody());
	    };
	}
}
