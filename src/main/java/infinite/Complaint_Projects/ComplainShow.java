package infinite.Complaint_Projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ComplainShow {
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cr","root","root");
			String cmd = "select *from Complaint";
			PreparedStatement pst = conn.prepareStatement(cmd);
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				System.out.println("*********************************************");
				System.out.println("The Complaint ID is " + res.getString("ComplaintID"));
				System.out.println("The Complaint Type is " + res.getString("ComplaintType"));
				System.out.println("The Complaint Description is " + res.getString("CDescription"));
				System.out.println("The ComplaintDate is " + res.getString("ComplaintDate"));
				System.out.println("The Severity is " + res.getString("Severity"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

}
}
