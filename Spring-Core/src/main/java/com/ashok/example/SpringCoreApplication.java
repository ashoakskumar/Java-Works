package com.ashok.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashok.example.component.MathComponent;
import com.ashok.example.component.PersonComponent;
import com.ashok.example.config.MyBeanConfiguration;
import com.ashok.example.config.PersonConfig;
import com.ashok.example.model.HelloMsg;
import com.ashok.example.model.MyBean;
import com.ashok.example.model.MyBean2;
import com.ashok.example.model.Person;
import com.ashok.example.model.PrintMsg;

@SpringBootApplication
public class SpringCoreApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringCoreApplication.class, args);
		ApplicationContext ctx = SpringApplication.run(SpringCoreApplication.class, args);
//		HelloMsg msg = ctx.getBean("message",HelloMsg.class);
//		System.out.println(msg.getMessage());
//		MathComponent mc = ctx.getBean(MathComponent.class);
//		System.out.println(mc.add(10, 10));
//		AnnotationConfigApplicationContext  ac = new AnnotationConfigApplicationContext();
//		ac.register(MyBeanConfiguration.class);
//		ac.refresh(); // needs to get called
//		MyBean2 mb1 = ac.getBean(MyBean2.class);
//		MyBean mb = mb1.getMyBean();
//		mb.printMessage();
//		ac.close();
//		AnnotationConfigApplicationContext  ac1 = new AnnotationConfigApplicationContext();
//		ac1.register(PersonConfig.class);
//		ac1.refresh();
//		PersonComponent pc = ctx.getBean(PersonComponent.class);
//		System.out.println(pc.getPerson1());
//		System.out.println(pc.getPerson2());
//		Person person = ctx.getBean("person2",Person.class);
//		System.out.println(person);
//		PrintMsg msgs = ctx.getBean("print",PrintMsg.class);
//		System.out.println(msgs.getMessage());
	}

}
