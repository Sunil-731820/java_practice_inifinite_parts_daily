package infinite.RealTimeLeaveMangement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowEmployeeMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionHelper.getConnection();
		String cmd = "select *from EMPLOYEE";
		PreparedStatement pst = connection.prepareStatement(cmd);
		ResultSet res = pst.executeQuery();
		while(res.next()) {
			System.out.println("The Employee Id is " + res.getInt("EMP_ID"));
			System.out.println("The Employee Name is " + res.getString("EMP_NAME"));
			System.out.println("The Employee Mail is " + res.getString("EMP_MAIL"));
			System.out.println("The Employee Mobile Number is "+ res.getString("EMP_MOB_NO"));
			System.out.println("The Employee Date of Joining is " + res.getString("EMP_DT_JOIN"));
			System.out.println("The Employee Department is " + res.getString("EMP_DEPT"));
			System.out.println("The Employee Manager is " + res.getInt("EMP_MANAGER_ID"));
			System.out.println("The Employee Leave is " + res.getInt("EMP_AVAIL_LEAVE_BAL"));
			System.out.println("--------------------------------------------------------------------");
		}
	}

}
