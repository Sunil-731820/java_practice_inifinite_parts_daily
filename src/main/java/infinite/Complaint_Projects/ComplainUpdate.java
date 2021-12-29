package infinite.Complaint_Projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ComplainUpdate {
	public static void main(String[] args) throws ParseException, SQLException {
		String ComplaintID,ComplaintType,CDescription,ComplaintDate,Severity;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ComplaintID here ");
		ComplaintID = sc.next();
		System.out.println("Enter the ComplaintType Here ");
		ComplaintType = sc.next();
		System.out.println("Enter the Complaint Description here ");
		CDescription = sc.next();
		System.out.println("Enter Complaint Date (yyyy-MM-dd)   ");
		ComplaintDate = sc.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date ComplaintDate1 = sdf.parse(ComplaintDate);
		System.out.println("Enter the severity here \n");
		Severity = sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cr","root","root");
			String cmd = "update Complaint set ComplaintType=?,CDescription=?,ComplaintDate=?,Severity=?" + "where ComplaintID=?";
			PreparedStatement pst = conn.prepareStatement(cmd);
			pst.setString(1, ComplaintType);
			pst.setString(2, CDescription);
			pst.setString(3, ComplaintDate);
			pst.setString(4, Severity);
			pst.setString(5, ComplaintID);
			pst.executeUpdate();
			System.out.println("********************Updated the Complaint SucceessFully ***************");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
