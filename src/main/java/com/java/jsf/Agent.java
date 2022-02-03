package com.java.jsf;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="agent")
@SessionScoped
public class Agent {
	
	private int agentId;
	private String name;
	private String city;
	private Gender gender;
	private int maritalStatus;
	private double premium;
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(int maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	
	static AgentDAO dao;
	static {
		dao = new AgentDAO();
	}
	
	public Agent[] showAgent()  throws ClassNotFoundException, SQLException {
		return dao.showAgent();
	}
	
	public String saveAgent(Agent agent) throws ClassNotFoundException, SQLException {
		dao.addAgent(agent);
		return "ShowAllAgent.xhtml?faces-redirect=true";
	}
	
	public String deleteAgent(int agentId) throws ClassNotFoundException, SQLException {
		dao.deleteAgent(agentId);
		return "ShowAllAgent.xhtml?faces-redirect=true";
	}
	
	public String updateAgent(Agent agent) throws ClassNotFoundException, SQLException {
		dao.updateAgent(agent);
		return "ShowAllAgent.xhtml?faces-redirect=true";
	}
	
}
