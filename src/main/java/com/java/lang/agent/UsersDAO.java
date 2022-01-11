package com.java.lang.agent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class UsersDAO {
	Connection connection;
	PreparedStatement pst;
	
	public int validate(String userName , String passCode) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select count(*) cnt from users where userName=? and passCode=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, userName);
		pst.setString(2, passCode);
		ResultSet res = pst.executeQuery();
		res.next();
		int count = res.getInt("cnt");
		return count;
	}

}
