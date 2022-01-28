package com.java.hib;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EmploySearch {
	public static void main(String[] args) {
		SessionFactory sf = SessionHelper.getFactory();
		Session s = sf.openSession();
		int empno;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Employ Number here ");
		empno = sc.nextInt();
		Query q = s.createQuery("from Employ where empno="+empno);
		List<Employ> employlist = q.list();
		if(employlist.size()==1) {
			Employ employ = employlist.get(0);
			System.out.println("Employ Number " + employ.getEmpno());
			System.out.println("Employ Name " + employ.getName());
			System.out.println("Gender "+ employ.getGender());
			System.out.println("Department " + employ.getDept());
			System.out.println("Designation " + employ.getDesig());
			System.out.println("Basic "+ employ.getBasic());
		}else {
			System.out.println("******Employ Id Does not match Check again*****");
		}
	}

}
