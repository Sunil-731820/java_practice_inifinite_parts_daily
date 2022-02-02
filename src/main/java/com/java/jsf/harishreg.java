package com.java.jsf;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="harishreg")
@SessionScoped
public class harishreg {
	
private String fname;
	
	
	private String email;
	
	
	private String pass;
	
	private int enrollnum;
	
	private int phoneNum;
	
	private String collegeName;
	
	private String branch;
	
	private int semester;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getEnrollnum() {
		return enrollnum;
	}

	public void setEnrollnum(int enrollnum) {
		this.enrollnum = enrollnum;
	}

	public int getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	
	static harishregDAO dao;
	static {
		dao = new harishregDAO();
	}
	
	
	public harishreg[] showReg()  throws ClassNotFoundException, SQLException {
		return dao.showReg();
	}
	
	
	public String saveEmploy(harishreg harishreg) throws ClassNotFoundException, SQLException {
		dao.addRegistration(harishreg);
		return "ShowRegAll.xhtml?faces-redirect=true";
 
		
	}
	
	
	

}
