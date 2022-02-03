package com.java.jsf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgentDAO {
	
	Connection connection ;
	PreparedStatement pst ;
	
	public Agent[] showAgent() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select *from Agent";
		pst = connection.prepareStatement(cmd);
		ResultSet res = pst.executeQuery();
		List<Agent> agentList = new ArrayList<Agent>();
		Agent agent = null;
		while(res.next()) {
			agent = new Agent();
			agent.setAgentId(res.getInt("agentId"));
			agent.setName(res.getString("name"));
			agent.setCity(res.getString("city"));
			agent.setGender(Gender.valueOf(res.getString("gender")));
			agent.setMaritalStatus(res.getInt("maritalStatus"));
			agent.setPremium(res.getDouble("premium"));
			agentList.add(agent);
		}
		return agentList.toArray(new Agent[agentList.size()]);
		
	}
	
	public String addAgent(Agent agent) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "insert into agent(agentId,name,city,Gender,maritalStatus,premium)"+
		" values (?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, agent.getAgentId());
		pst.setString(2, agent.getName());
		pst.setString(3, agent.getCity());
		pst.setString(4,agent.getGender().toString());
		pst.setInt(5, agent.getMaritalStatus());
		pst.setDouble(6, agent.getPremium());
		pst.executeUpdate();
		return "Agent date is Inserted";
	}
	
	public String deleteAgent(int agentId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "delete from agent where agentId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, agentId);
		pst.executeUpdate();
		return "Agent Data Deleted Successfully";
		
	}
	
	
	
	public String updateAgent(Agent agent) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
//		String gender = "MALE";
//		Gender g = Gender.valueOf(gender);
		String cmd = "update agent set Name=? , City=?,GENDER=?,MaritalStatus=?,Premium=? where AgentId=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, agent.getName());
		pst.setString(2, agent.getCity());
		pst.setString(3, agent.getGender().toString());
		pst.setInt(4, agent.getMaritalStatus());
		pst.setDouble(5, agent.getPremium());
		pst.setInt(6, agent.getAgentId());
		pst.executeUpdate();
		return "Agent Data UPdated ";
	}
	
	public Agent searchAgent(int agentId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select *from agent where agentId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, agentId);
		ResultSet res = pst.executeQuery();
		Agent agent = null;
		if(res.next()) {
			agent = new Agent();
			agent.setAgentId(res.getInt("AgentId"));
			agent.setName(res.getString("Name"));
			agent.setCity(res.getString("City"));
			agent.setGender(Gender.valueOf(res.getString("gender")));
			agent.setMaritalStatus(res.getInt("MaritalStatus"));
			agent.setPremium(res.getDouble("Premium"));
		}
		return agent;
		
	}

}
