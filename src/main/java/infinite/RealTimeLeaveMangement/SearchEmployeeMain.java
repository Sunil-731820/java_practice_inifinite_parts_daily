package infinite.RealTimeLeaveMangement;

import java.sql.SQLException;
import java.util.Scanner;

public class SearchEmployeeMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int EMP_ID;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Employee to search here ");
		EMP_ID = sc.nextInt();
		Leave leave = new LeaveDAO().searchLeave(EMP_ID);
		if(leave!=null) {
			System.out.println(leave);
		}else {
			System.out.println("****The Employee records Does Not Exist *****");
		}
	}

}
