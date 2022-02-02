package com.java.jsf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class harishregDAO {
	
	Connection connection;
	PreparedStatement pst;
	
	public harishreg[] showReg() throws ClassNotFoundException, SQLException {
		
		connection = ConnectionHelper.getConnection();
		String cmd = "select *from harishreg";
		pst = connection.prepareStatement(cmd);
		ResultSet res = pst.executeQuery();
		List<harishreg> employList = new ArrayList<harishreg>();
		harishreg reg = null;
		while(res.next()) {
			reg = new harishreg();
			reg.setFname(res.getString("fname"));
			reg.setEmail(res.getString("email"));
			reg.setPass(res.getString("password"));
			reg.setEnrollnum(res.getInt("enrollnum"));
			reg.setPhoneNum(res.getInt("phonenum"));
			reg.setCollegeName(res.getString("colname"));
			reg.setBranch(res.getString("branch"));
			reg.setSemester(res.getInt("semester"));
			employList.add(reg);
		}
		return employList.toArray(new harishreg[employList.size()]); 
	}
	
	
	public String addRegistration(harishreg harish) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "insert into harishreg(fname,email,password,enrollnum,phonenum,colname,branch,semester) values(?,?,?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, harish.getFname());
		pst.setString(2, harish.getEmail());
		pst.setString(3, harish.getPass());
		pst.setInt(4, harish.getEnrollnum());
		pst.setInt(5, harish.getPhoneNum());
		pst.setString(6, harish.getCollegeName());
		pst.setString(7, harish.getBranch());
		pst.setInt(8, harish.getSemester());
		pst.executeUpdate();
		return "Registred";
	}
	
	
	
	
	

}
