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
	
	public String addEmploy(Employ employ) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "insert into Employ(Empno,name,Gender,Dept,Desig,Basic) values(?,?,?,?,?,?) ";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, employ.getEmpno());
		pst.setString(2, employ.getName());
		pst.setString(3, employ.getGender());
		pst.setString(4, employ.getDept());
		pst.setString(5, employ.getDesig());
		pst.setInt(6, employ.getBasic());
		pst.executeUpdate();
		return "the Records are added SuccessFully*************";
		
	}
	
	public int generateEmployNo() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select  max(empno)+1 eno from Employ ";
		pst = connection.prepareStatement(cmd);
		ResultSet res = pst.executeQuery();
		res.next();
		int empno = res.getInt("eno");
		return empno;
		
	}
	
	public String deleteEmploy(int empno) throws ClassNotFoundException, SQLException {
		connection =ConnectionHelper.getConnection();
		String cmd = "delete from Employ where empno=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, empno);
		pst.executeUpdate();
		return "Records Deleted SuccessFully **********";
		
		
	}
	
	public String updateEmploy(Employ employ) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Update Employ set name=?,Gender=?,Dept=?,Desig=?,Basic=? where Empno=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, employ.getName());
		pst.setString(2, employ.getGender());
		pst.setString(3, employ.getDept());
		pst.setString(4, employ.getDesig());
		pst.setInt(5, employ.getBasic());
		pst.setInt(6, employ.getEmpno());
		pst.executeUpdate();
		return "Records updated Successfully *********";
	}
	
	public Employ searchEmploy(int empno) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select *from Employ where empno=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, empno);
		ResultSet res = pst.executeQuery();
		Employ employ = null;
		if(res.next()) {
			employ = new Employ();
			employ.setEmpno(res.getInt("Empno"));
			employ.setName(res.getString("name"));
			employ.setGender(res.getString("Gender"));
			employ.setDept(res.getString("Dept"));
			employ.setDesig(res.getString("Desig"));
			employ.setBasic(res.getInt("Basic"));
		}
		return employ;
		
	}
	
	
	public Employ[] showEmploy() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select *from Employ";
		pst = connection.prepareStatement(cmd);
		ResultSet res = pst.executeQuery();
		List<Employ> employList = new ArrayList<Employ>();
		Employ employ = null;
		while(res.next()) {
			employ = new Employ();
			employ.setEmpno(res.getInt("Empno"));
			employ.setName(res.getString("name"));
			employ.setGender(res.getString("Gender"));
			employ.setDept(res.getString("Dept"));
			employ.setDesig(res.getString("Desig"));
			employ.setBasic(res.getInt("Basic"));
			employList.add(employ);
		}
		return employList.toArray(new Employ[employList.size()]);
	}

}
