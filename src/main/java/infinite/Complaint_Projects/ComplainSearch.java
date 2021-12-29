package infinite.Complaint_Projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ComplainSearch {
	public static void main(String[] args) throws SQLException {
		String ComplaintID;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ComplaintID here for searching the data ");
		ComplaintID = sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cr","root","root");
			String cmd = "select *from Complaint where ComplaintID=?";
			PreparedStatement pst = conn.prepareStatement(cmd);
			pst.setString(1, ComplaintID);
			ResultSet res = pst.executeQuery();
			System.out.println("*********After performing the Search operation **************");
			if(res.next()) {
				System.out.println("The Complaint Id is  \n" + res.getString("ComplaintID"));
				System.out.println("The ComplaintType is \n" +res.getString("ComplaintType"));
				System.out.println("The Complaint Description is \n" + res.getString("CDescription"));
				System.out.println("The Complaint Date is \n" + res.getString("ComplaintDate"));
				System.out.println("The severity is \n" + res.getString("Severity"));
				System.out.println("----------------------------------------------------------------");
			}else {
				System.out.println("The Complaint Does not Found in the table ");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
