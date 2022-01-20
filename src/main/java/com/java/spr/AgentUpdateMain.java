package com.java.spr;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AgentUpdateMain {
	public static void main(String[] args) {
		Agent agent = new Agent();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Agentid\n");
		agent.setAgentId(sc.nextInt());
		System.out.println("enter the name");
		agent.setName(sc.next());
		System.out.println("enter the city ");
		agent.setCity(sc.next());
		System.out.println("Enter the Gender");
		agent.setGender(Gender.valueOf(sc.next()));
		System.out.println("Enter the maritalStatus");
		agent.setMaritalStatus(sc.nextInt());
		System.out.println("Enter the premium ");
		agent.setPremium(sc.nextInt());
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/spr/jdbc.xml");
		AgentDAO dao = (AgentDAO)ctx.getBean("agentDao");
		System.out.println(dao.updateAgent(agent));
	}

}
