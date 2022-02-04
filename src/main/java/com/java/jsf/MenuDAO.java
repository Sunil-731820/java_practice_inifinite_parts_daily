package com.java.jsf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO {
	
	Connection connection ;
	PreparedStatement pst;
	
	public Menu[] showMenu() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select *from menu";
		pst = connection.prepareStatement(cmd);
		ResultSet res = pst.executeQuery();
		List<Menu> menuList = new ArrayList<Menu>();
		Menu menu = null;
		while(res.next()) {
			menu = new Menu();
			menu.setMenId(res.getInt("MEN_ID"));
			menu.setMenItem(res.getString("MEN_ITEM"));
			menu.setMenPrice(res.getDouble("MEN_PRICE"));
			menu.setMenCalories(res.getDouble("MEN_CALORIES"));
			menu.setMenSpeciality(res.getString("MEN_SPECIALITY"));
			menuList.add(menu);
		}
		return menuList.toArray(new Menu[menuList.size()]);
	}
	
	public String addMenu(Menu menu) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "insert into menu(MEN_ID,MEN_ITEM,MEN_PRICE,MEN_CALORIES,MEN_SPECIALITY) values(?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1,menu.getMenId());
		pst.setString(2, menu.getMenItem());
		pst.setDouble(3, menu.getMenPrice());
		pst.setDouble(4, menu.getMenCalories());
		pst.setString(5, menu.getMenSpeciality());
		pst.executeUpdate();
		return "Menu Added SuccessFully"; 
	}
	
	public String deleteMenu(int menId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "delete from menu where MEN_ID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, menId);
		pst.executeUpdate();
		return "Menu Data Deleted Successfully";
		
	}
	
	public String updateMenu(Menu menu) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "update menu set MEN_ITEM=?,MEN_PRICE=?,MEN_CALORIES=?,MEN_SPECIALITY=? where MEN_ID=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, menu.getMenItem());
		pst.setDouble(2, menu.getMenPrice());
		pst.setDouble(3, menu.getMenCalories());
		pst.setString(4, menu.getMenSpeciality());
		pst.setInt(5,menu.getMenId());
		pst.executeUpdate();
		return "Menu Updated SuccessFully";
	}
	
	public Menu searchMenu(int menId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select *from menu where menId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, menId);
		ResultSet res = pst.executeQuery();
		Menu menu = null;
		if(res.next()) {
			menu = new Menu();
			menu.setMenId(res.getInt("MEN_ID"));
			menu.setMenItem(res.getString("MEN_ITEM"));
			menu.setMenPrice(res.getDouble("MEN_PRICE"));
			menu.setMenCalories(res.getDouble("MEN_CALORIES"));
			menu.setMenSpeciality(res.getString("MEN_SPECIALITY"));
		}
		return menu;
		
	}
	
	

}
