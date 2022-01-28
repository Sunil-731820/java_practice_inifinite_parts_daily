package com.java.hib;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AgentDAO {
	SessionFactory sf;
	Session session;
	
	public List<Agent> showAgent(){
		SessionFactory sf = SessionHelper.getFactory();
		Session session = sf.openSession();
		Query q = session.createQuery("from Agent");
		List<Agent> agentList = q.list();
		return agentList;
	}
	
	public Agent searchAgent(int agentId) {
		SessionFactory sf = SessionHelper.getFactory();
		Session session = sf.openSession();
		Query q = session.createQuery("from Agent where agentId="+agentId);
		List<Agent> agentList = q.list();
		Agent  agent = null;
		if(agentList.size()==1) {
			agent = agentList.get(0);
		}
		return agent;
	}
	
	public String addAgent(Agent agent) {
		SessionFactory sf = SessionHelper.getFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(agent);
		t.commit();
		return "data added SuccessFully";
	}
	
	public String updateAgent(Agent agent) {
		SessionFactory sf = SessionHelper.getFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.update(agent);
		t.commit();
		return "Record Updated...";
	}
	
	public String deleteAgent(int agentId) {
		SessionFactory sf = SessionHelper.getFactory();
		Session s = sf.openSession();
		Agent agent = searchAgent(agentId);
		s.close();
		s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.delete(agent);
		t.commit();
		return "records deleted from the table";
		
	}
}
