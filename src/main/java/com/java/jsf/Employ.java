package com.java.jsf;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="employ")
@SessionScoped
public class Employ {
	
	private int empno;
	private String name;
	private Gender gender;
	private String dept;
	private String desig;
	private int basic;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public int getBasic() {
		return basic;
	}
	public void setBasic(int basic) {
		this.basic = basic;
	}
	
	static EmployDAo dao;
	static {
		dao = new EmployDAo();
	}
	
	public Employ[] showEmploy()  throws ClassNotFoundException, SQLException {
		return dao.showEmploy();
	}
	
	public String saveEmploy(Employ employ) throws ClassNotFoundException, SQLException {
		dao.addEmploy(employ);
		return "CreateEmploy.xhtml?faces-redirect=true";
	}
	
	public String deleteEmploy(int empno) throws ClassNotFoundException, SQLException {
		dao.deleteEmploy(empno);
		return "EmployShowAll.xhtml?faces-redirect=true";
	}
	
	public String updateEmploy(Employ employ) throws ClassNotFoundException, SQLException {
		dao.updateEmploy(employ);
		return "EmployShowAll.xhtml?faces-redirect=true";
	}

}
