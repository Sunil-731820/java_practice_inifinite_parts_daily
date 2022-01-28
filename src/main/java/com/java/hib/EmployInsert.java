package com.java.hib;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployInsert {
	public static void main(String[] args) {
		Employ employ = new Employ();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Employ Number");
		employ.setEmpno(sc.nextInt());
		System.out.println("Enter the Employ Name ");
		employ.setName(sc.next());
		System.out.println("Enter the gender");
		employ.setGender(Gender.valueOf(sc.next()));
		System.out.println("Enter the Department");
		employ.setDept(sc.next());
		System.out.println("Enter the Designation");
		employ.setDesig(sc.next());
		System.out.println("Enter the basic");
		employ.setBasic(sc.nextInt());
		
		SessionFactory sf = SessionHelper.getFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(employ);
		t.commit();
		System.out.println("***********Records Inserted SuccessFully*******");
	}

}
