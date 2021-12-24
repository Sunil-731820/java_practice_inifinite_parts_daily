package infinite.RealTimeLeaveMangement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeaveDAO {
	Connection connection;
	PreparedStatement pst;
//	second task is to showAll Employee Records from the table 
	public Leave[] ShowAllEmployee() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select *from EMPLOYEE where EMP_ID=?";
		List<Leave> leavelist = new ArrayList();
		pst = connection.prepareStatement(cmd);
		ResultSet res = pst.executeQuery();
		Leave leave = null;
		while(res.next()) {
			leave = new Leave();
			System.out.println("The Employee is " + res.getInt("EMP_ID"));
			System.out.println("the Employee Name is "+ res.getString("EMP_NAME"));
			System.out.println("The Employee MAil is " + res.getString("EMP_MAIL"));
			System.out.println("The Employee Mobile Number is " + res.getInt("EMP_MOB_NO"));
			System.out.println("The Employee date of joining is" + res.getDate("EMP_DT_JOIN"));
			System.out.println("The Employee Department is " + res.getString("EMP_DEPT"));
			System.out.println("The Employee Manager Id is " + res.getInt("EMP_MANAGER_ID"));
			System.out.println("The Employee Leave Bal is " + res.getInt("EMP_AVAIL_LEAVE_BAL"));
		}
		return leavelist.toArray(new Leave[leavelist.size()]);

	}
	
	
	
//	first we have to perform search Operations 
	public Leave searchLeave(int EMP_ID) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select *from EMPLOYEE where EMP_ID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, EMP_ID);
		ResultSet res = pst.executeQuery();
		Leave leave = null;
		if(res.next()) {
			leave.setEMP_ID(res.getInt("EMP_ID"));
			leave.setEmp_NAME(res.getString("EMP_NAME"));
			leave.setEMP_MAIL(res.getString("EMP_MAIL"));
			leave.setEMP_MOB_NO(res.getString("EMP_MOB_NO"));
			leave.setEMP_DT_JOIN(res.getDate("EMP_DT_JOIN"));
			leave.setEMP_DEPT(res.getString("EMP_DEPT"));
			leave.setEMP_MANAGER_ID(res.getInt("EMP_MANAGER_ID"));
			leave.setEMP_AVAIL_LEAVE_BAL(res.getInt("EMP_AVAIL_LEAVE_BAL"));
		}
		return leave;
	}
}
