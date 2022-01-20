package com.java.spr;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AgentSearchMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/spr/jdbc.xml");
		AgentDAO dao = (AgentDAO)ctx.getBean("agentDao");
		int agentId;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the AGent Id here for searching ");
		agentId = sc.nextInt();
		Agent agent = dao.searchAgent(agentId);
		if(agent!=null) {
			System.out.println(agent);
		}else {
			System.out.println("Agent Records Does not exist");
		}
	}
	
	
	

}
