package com.java.jsf;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="menu")
@SessionScoped
public class Menu {
	private int menId;
	private String menItem;
	private double menPrice;
	private double menCalories;
	private String menSpeciality;
	public int getMenId() {
		return menId;
	}
	public void setMenId(int menId) {
		this.menId = menId;
	}
	public String getMenItem() {
		return menItem;
	}
	public void setMenItem(String menItem) {
		this.menItem = menItem;
	}
	public double getMenPrice() {
		return menPrice;
	}
	public void setMenPrice(double menPrice) {
		this.menPrice = menPrice;
	}
	public double getMenCalories() {
		return menCalories;
	}
	public void setMenCalories(double menCalories) {
		this.menCalories = menCalories;
	}
	public String getMenSpeciality() {
		return menSpeciality;
	}
	public void setMenSpeciality(String menSpeciality) {
		this.menSpeciality = menSpeciality;
	}
	
	static MenuDAO dao;
	static {
		dao = new MenuDAO();
	}
	
	public Menu[] showMenu() throws ClassNotFoundException, SQLException {
		return dao.showMenu();
	}
	
	public String saveMenu(Menu menu) throws ClassNotFoundException, SQLException {
		dao.addMenu(menu);
		return "ShowAllMenu.xhtml?faces-redirect=true";
	}
	
	public String deleteMenu(int menId) throws ClassNotFoundException, SQLException {
		dao.deleteMenu(menId);
		return "ShowAllMenu.xhtml?faces-redirect=true";
	}
	
	public String updateMenu(Menu menu) throws ClassNotFoundException, SQLException {
		dao.updateMenu(menu);
		return "ShowAllMenu.xhtml?faces-redirect=true";
	}
	
	
	
	

}
