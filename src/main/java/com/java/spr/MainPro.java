package com.java.spr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainPro {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/spr/Hello.xml");
		Hello helo = (Hello) ctx.getBean("bean1");
		System.out.println(helo.sayHello("Sunil"));
		
	}

}
