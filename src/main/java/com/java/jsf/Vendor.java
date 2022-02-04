package com.java.jsf;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Vendor {
	
	private int venId;
	private String venname;
	private String phoneNum;
	private String userName;
	private String passWord;
	private String email;
	public int getVenId() {
		return venId;
	}
	public void setVenId(int venId) {
		this.venId = venId;
	}
	public String getVenname() {
		return venname;
	}
	public void setVenname(String venname) {
		this.venname = venname;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	static CustomerDAO dao ;
	static {
		dao = new CustomerDAO();
	}
	
	
	public Vendor[] showVendor() throws ClassNotFoundException, SQLException {
		return dao.showVendor();
	}
	
}
