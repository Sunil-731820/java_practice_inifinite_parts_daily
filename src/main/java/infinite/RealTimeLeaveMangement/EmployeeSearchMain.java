package infinite.RealTimeLeaveMangement;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeSearchMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int empno;
		System.out.println("Enter Employ No   ");
		empno = sc.nextInt();
		EmployeeDAO dao = new EmployeeDAO();
		try {
			Employee employee = dao.searchEmploy(empno);
			if (employee!=null) {
				System.out.println(employee);
			} else {
				System.out.println("*** Record Not Found ***");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
