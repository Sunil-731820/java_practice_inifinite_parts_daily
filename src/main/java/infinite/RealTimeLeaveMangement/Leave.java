package infinite.RealTimeLeaveMangement;

import java.math.BigInteger;
import java.sql.Date;

public class Leave {
	private int EMP_ID;
	private String Emp_NAME;
	private String EMP_MAIL;
	private String EMP_MOB_NO;
	private Date EMP_DT_JOIN;
	private String EMP_DEPT;
	private int EMP_MANAGER_ID;
	private int EMP_AVAIL_LEAVE_BAL;
	public int getEMP_ID() {
		return EMP_ID;
	}
	public void setEMP_ID(int eMP_ID) {
		EMP_ID = eMP_ID;
	}
	public String getEmp_NAME() {
		return Emp_NAME;
	}
	public void setEmp_NAME(String emp_NAME) {
		Emp_NAME = emp_NAME;
	}
	public String getEMP_MAIL() {
		return EMP_MAIL;
	}
	public void setEMP_MAIL(String eMP_MAIL) {
		EMP_MAIL = eMP_MAIL;
	}
	public String getEMP_MOB_NO() {
		return EMP_MOB_NO;
	}
	public void setEMP_MOB_NO(String eMP_MOB_NO) {
		EMP_MOB_NO = eMP_MOB_NO;
	}
	public Date getEMP_DT_JOIN() {
		return EMP_DT_JOIN;
	}
	public void setEMP_DT_JOIN(Date eMP_DT_JOIN) {
		EMP_DT_JOIN = eMP_DT_JOIN;
	}
	public String getEMP_DEPT() {
		return EMP_DEPT;
	}
	public void setEMP_DEPT(String eMP_DEPT) {
		EMP_DEPT = eMP_DEPT;
	}
	public int getEMP_MANAGER_ID() {
		return EMP_MANAGER_ID;
	}
	public void setEMP_MANAGER_ID(int eMP_MANAGER_ID) {
		EMP_MANAGER_ID = eMP_MANAGER_ID;
	}
	public int getEMP_AVAIL_LEAVE_BAL() {
		return EMP_AVAIL_LEAVE_BAL;
	}
	public void setEMP_AVAIL_LEAVE_BAL(int eMP_AVAIL_LEAVE_BAL) {
		EMP_AVAIL_LEAVE_BAL = eMP_AVAIL_LEAVE_BAL;
	}
	@Override
	public String toString() {
		return "Leave [EMP_ID=" + EMP_ID + ", Emp_NAME=" + Emp_NAME + ", EMP_MAIL=" + EMP_MAIL + ", EMP_MOB_NO="
				+ EMP_MOB_NO + ", EMP_DT_JOIN=" + EMP_DT_JOIN + ", EMP_DEPT=" + EMP_DEPT + ", EMP_MANAGER_ID="
				+ EMP_MANAGER_ID + ", EMP_AVAIL_LEAVE_BAL=" + EMP_AVAIL_LEAVE_BAL + "]";
	}
	
	
	
}
