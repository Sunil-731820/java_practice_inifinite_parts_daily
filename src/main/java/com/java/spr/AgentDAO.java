package com.java.spr;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class AgentDAO {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Agent> showAgent(){
		String cmd = "select *from agent";
		List<Agent> agentList = jdbcTemplate.query(cmd, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Agent agent = new Agent();
				agent.setAgentId(rs.getInt("agentId"));
				agent.setName(rs.getString("name"));
				agent.setCity(rs.getString("city"));
				agent.setGender(Gender.valueOf(rs.getString("gender")));
				agent.setMaritalStatus(rs.getInt("maritalStatus"));
				agent.setPremium(rs.getInt("premium"));
				return agent;
			}
		});
		return agentList;
	}
	
	
	public Agent searchAgent(int agentId) {
		String cmd = "select * from agent where agentId=?";
		List<Agent> agentList = jdbcTemplate.query(cmd, new Object[] {agentId}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Agent agent = new Agent();
				agent.setAgentId(rs.getInt("agentId"));
				agent.setName(rs.getString("name"));
				agent.setCity(rs.getString("city"));
				agent.setGender(Gender.valueOf(rs.getString("gender")));
				agent.setMaritalStatus(rs.getInt("maritalStatus"));
				agent.setPremium(rs.getInt("premium"));
				return agent;
			}
		});
		if (agentList.size()==1) {
			return agentList.get(0);
		}
		return null;
	}
	
	public String addAgent(Agent agent) {
		String cmd = "Insert into agent(agentId,name,city,gender,maritalStatus,premium) "
				+ " values(?,?,?,?,?,?)";
		jdbcTemplate.update(cmd, new Object[] {agent.getAgentId(), agent.getName(), agent.getCity(),
				agent.getGender().toString(),agent.getMaritalStatus(),agent.getPremium()
			});
		return " Agent Record Added SuccessFully ...";
	}
	
	
	public String deleteAgent(int agentId) {
		Agent AgentFound = searchAgent(agentId);
		if (AgentFound!=null) {
			String cmd = "Delete From agent where agentId=?";
			jdbcTemplate.update(cmd, new Object[] {agentId});
			return " Agent Record Deleted...";
		}
		return " Agent Record Not Found...";
	}
	
	public String updateAgent(Agent agent) {
		Agent agentFound = searchAgent(agent.getAgentId());
		if (agentFound !=null) {
		String cmd = "Update agent Set name=?, city=?, gender=?, maritalStatus=?, premium=? where agentId=?";
		jdbcTemplate.update(cmd, new Object[] {agent.getName(), agent.getCity(),
				agent.getGender().toString(),agent.getMaritalStatus(),agent.getPremium(),  
				agent.getAgentId()
			});
		return " agent Record Updated...";
		}
		return "Record Not Found...";
	}
	

}
