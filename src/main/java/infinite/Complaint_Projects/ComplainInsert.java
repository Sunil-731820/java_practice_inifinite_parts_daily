package infinite.Complaint_Projects;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ComplainInsert {
	public static void main(String[] args) throws ParseException, SQLException {
		String ComplaintID,ComplaintType,CDescription,Severity;
		String ComplaintDate;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Complain Id Here \n");
		ComplaintID = sc.next();
		System.out.println("Enter the Complain Type here \n");
		ComplaintType = sc.next();
		System.out.println("Enter the Complain Description here \n");
		CDescription = sc.next();
		System.out.println("Enter Complaint Date (yyyy-MM-dd)   ");
		ComplaintDate = sc.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sdf.parse(ComplaintDate);
		System.out.println("Enter the severity here \n");
		Severity = sc.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cr","root","root");
			String cmd = "insert into Complaint(ComplaintID,ComplaintType,CDescription,ComplaintDate,Severity)values(?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(cmd);
			pst.setString(1, ComplaintID);
			pst.setString(2, ComplaintType);
			pst.setString(3, CDescription);
			pst.setString(4, ComplaintDate);
			pst.setString(5, Severity);
			pst.executeUpdate();
			System.out.println("the Complaint is Added Succeessfully ");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
