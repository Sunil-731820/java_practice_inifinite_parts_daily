package com.java.spr;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AgentDeleteMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/spr/jdbc.xml");
		AgentDAO dao = (AgentDAO)ctx.getBean("agentDao");
		int agentId ;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the agent Id here for deletion ");
		agentId = sc.nextInt();
		System.out.println(dao.deleteAgent(agentId));
	}

}
