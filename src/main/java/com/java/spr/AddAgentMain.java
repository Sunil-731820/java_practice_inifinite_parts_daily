package com.java.spr;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddAgentMain {
	public static void main(String[] args) {
		Agent agent = new Agent();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the agent id here \n");
		agent.setAgentId(sc.nextInt());
		System.out.println("Enter the agent Name here \n");
		agent.setName(sc.next());
		System.out.println("Enter the Agent CIty here \n");
		agent.setCity(sc.next());
		System.out.println("Enter the Gender here \n");
		agent.setGender(Gender.valueOf(sc.next()));
		System.out.println("Enter the maritalStatus here \n");
		agent.setMaritalStatus(sc.nextInt());
		System.out.println("Enter the Premium here \n");
		agent.setPremium(sc.nextInt());
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/spr/jdbc.xml");
		AgentDAO dao = (AgentDAO)ctx.getBean("agentDao");
		System.out.println(dao.addAgent(agent));
		
	}

}
