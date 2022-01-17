package com.java.rest;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/agentService")
public class AgentService {
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Agent[] showAgent() throws ClassNotFoundException, SQLException {
		return new AgentDAO().showAgent();
	}
	
	@GET
	@Path("/{agentId}")
	@Produces(MediaType.APPLICATION_XML)
	public Agent searchAgent(@PathParam("agentId") int agentID) throws ClassNotFoundException, SQLException {
		return new AgentDAO().searchAgent(agentID);
		
	}

}
