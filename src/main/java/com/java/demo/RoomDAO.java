package com.java.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDAO {
	
	@Autowired  
    JdbcTemplate jdbc;  
	
	public String RoomAvailable(String status) {
		String cmd = "select count(*) cnt from room where status=? ";
		List str=jdbc.query(cmd,new Object[] {status}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return rs.getInt("cnt");
			}
			
		});
		return str.get(0).toString();
	}
	
	
	public String RoomBooked(String status) {
		String cmd = "select count(*) cnt from room where status=? ";
		List str=jdbc.query(cmd,new Object[] {status}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return rs.getInt("cnt");
			}
			
		});
		return str.get(0).toString();
	}

}
