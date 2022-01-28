package com.java.hib;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployDAO {
	SessionFactory sf;
	Session session;
	
	public List<Employ> showEmploy(){
		SessionFactory sf = SessionHelper.getFactory();
		Session session = sf.openSession();
		Query q = session.createQuery("from Employ");
		List<Employ> employList = q.list();
		return employList;
	}
	
	public Employ searchEmploy(int empno) {
		SessionFactory sf = SessionHelper.getFactory();
		Session session = sf.openSession();
		Query q = session.createQuery("from Employ where empno="+empno);
		List<Employ> employList = q.list();
		Employ  employ = null;
		if(employList.size()==1) {
			employ = employList.get(0);
		}
		return employ;
	}
	
	public String addEmploy(Employ employ) {
		SessionFactory sf = SessionHelper.getFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(employ);
		t.commit();
		return "data added SuccessFully";
	}
	
	public String deleteEmploy(int empno) {
		SessionFactory sf = SessionHelper.getFactory();
		Session s = sf.openSession();
		Employ employ = searchEmploy(empno);
		s.close();
		s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.delete(employ);
		t.commit();
		return "records deleted from the table";
		
	}
	

	public String updateEmploy(Employ employ) {
		SessionFactory sf = SessionHelper.getFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.update(employ);
		t.commit();
		return "Record Updated...";
	}

}
