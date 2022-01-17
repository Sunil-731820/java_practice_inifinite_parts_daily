package com.java.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgentDAO {
	
	Connection connection;
	PreparedStatement pst;
	
	public Agent[] showAgent() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select *from agent";
		pst = connection.prepareStatement(cmd);
		ResultSet res = pst.executeQuery();
		List<Agent> agentList = new ArrayList<Agent>();
		Agent agent = null;
		while(res.next()) {
			agent = new Agent();
			agent.setAgentId(res.getInt("AgentID"));
			agent.setName(res.getString("Name"));
			agent.setCity(res.getString("City"));
			agent.setGender(Gender.valueOf(res.getString("GENDER")));
			agent.setMaritalStatus(res.getInt("MaritalStatus"));
			agent.setPremium(res.getDouble("Premium"));
			agentList.add(agent);
		}
		return agentList.toArray(new Agent[agentList.size()]);
	}
	
	public Agent searchAgent(int agentId) throws SQLException, ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select *from agent where agentId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, agentId);
		ResultSet res = pst.executeQuery();
		Agent agent = null;
		if(res.next()) {
			agent = new Agent();
			agent.setAgentId(res.getInt("AgentID"));
			agent.setName(res.getString("Name"));
			agent.setCity(res.getString("City"));
			agent.setGender(Gender.valueOf(res.getString("GENDER")));
			agent.setMaritalStatus(res.getInt("MaritalStatus"));
			agent.setPremium(res.getDouble("Premium"));
		}
		return agent;
		
	}

}
