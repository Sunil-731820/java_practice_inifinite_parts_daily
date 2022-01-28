package com.java.hib;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class EmployShowAll {
	public static void main(String[] args) {
		
		SessionFactory sf = SessionHelper.getFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from Employ");	
		List<Employ> employList = q.list();
		for (Employ employee : employList) {
			System.out.println("Employ Number " + employee.getEmpno());
			System.out.println("Employ Name " + employee.getName());
			System.out.println("Gender " + employee.getGender());
			System.out.println("Department " + employee.getDept());
			System.out.println("Designation " + employee.getDesig());
			System.out.println("Basic "+ employee.getBasic());
			
		}
	}

}
