package infinite.Complaint_Projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ComplainDelete {
	public static void main(String[] args) throws SQLException {
		String ComplaintID;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Complaint Id here for deletion *****");
		ComplaintID = sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cr","root","root");
			String cmd = "delete from Complaint where ComplaintID=?";
			PreparedStatement pst = conn.prepareStatement(cmd);
			pst.setString(1,ComplaintID);
			pst.executeUpdate();
			System.out.println("***********the Complaint is deleted from the table SuccessFully **************");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
