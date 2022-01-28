package com.java.hib;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployUpdate {
	public static void main(String[] args) {
		Employ employ = new Employ();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Employ Number");
		employ.setEmpno(sc.nextInt());
		System.out.println("Enter the Employ name");
		employ.setName(sc.next());
		System.out.println("Enter the gender");
		String gen = sc.next();
		if(gen.toUpperCase().equals("MALE")){
			employ.setGender(Gender.MALE);
		}
		if(gen.toUpperCase().equals("FEMALE")) {
			employ.setGender(Gender.FEMALE);
		}
		
		System.out.println("Enter the Department ");
		employ.setDept(sc.next());
		System.out.println("Enter the Designation");
		employ.setDesig(sc.next());
		System.out.println("Enter the basic");
		employ.setBasic(sc.nextInt());
		
		
		SessionFactory sf = SessionHelper.getFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		session.update(employ);
		t.commit();
		System.out.println("****Data Updated SucceessFully********");
	}

}
