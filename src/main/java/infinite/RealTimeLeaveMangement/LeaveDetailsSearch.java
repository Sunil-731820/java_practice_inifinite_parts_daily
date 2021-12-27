package infinite.RealTimeLeaveMangement;


import java.sql.SQLException;
import java.util.Scanner;

public class LeaveDetailsSearch {

	public static void main(String[] args) {
		int leaveId;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Leave Id   ");
		leaveId = sc.nextInt();
		LeaveDetailsDAO dao = new LeaveDetailsDAO();
		try {
			LeaveDetails leaveDetails = dao.searchByLeaveId(leaveId);
			if (leaveDetails!=null) {
				System.out.println(leaveDetails);
			} else {
				System.out.println("*** LeaveDetails Not Found ***");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}