package com.java.dashborad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployDAO {
	Connection connection;
	PreparedStatement pst;
	
	
	public String updateEmploy(Employ employ) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Update Student17 set lastName=?,age=?,location=? where firstName=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, employ.getLastName());
		pst.setInt(2, employ.getAge());
		pst.setString(3, employ.getLocation());
		pst.setString(4, employ.getFirstName());
		pst.executeUpdate();
		return "Records updated Successfully *********";
	}
	
	
	public Employ searchEmploy(String firstName) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select *from Student17 where firstName=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, firstName);
		ResultSet res = pst.executeQuery();
		Employ employ = null;
		if(res.next()) {
			employ = new Employ();
			employ.setFirstName(res.getString("firstName"));
			employ.setLastName(res.getString("lastName"));
			employ.setAge(res.getInt("age"));
			employ.setLocation(res.getString("location"));
		}
		return employ;
		
	}
	
	public String addEmploy(Employ employ) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "insert into Student17(firstName,lastName,age,location) values(?,?,?,?) ";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, employ.getFirstName());
		pst.setString(2, employ.getLastName());
		pst.setInt(3, employ.getAge());
		pst.setString(4, employ.getLocation());
		pst.executeUpdate();
		return "***********the Records are added SuccessFully*************";
		
	}
	
	public String deleteEmploy(String firstName) throws ClassNotFoundException, SQLException {
		connection =ConnectionHelper.getConnection();
		String cmd = "delete from Student17 where firstName=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, firstName);
		pst.executeUpdate();
		return "Records Deleted SuccessFully **********";
		
		
	}
	
	
	public Employ[] showEmploy() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select *from Student17";
		pst = connection.prepareStatement(cmd);
		ResultSet res = pst.executeQuery();
		List<Employ> employList = new ArrayList<Employ>();
		Employ employ = null;
		while(res.next()) {
			employ = new Employ();
			employ.setFirstName(res.getString("firstName"));
			employ.setLastName(res.getString("lastName"));
			employ.setAge(res.getInt("age"));
			employ.setLocation(res.getString("location"));
			employList.add(employ);
		}
		return employList.toArray(new Employ[employList.size()]);
	}

	
}
