package infinite.BankDatabaseProjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BankSearch {
	public static void main(String[] args) throws SQLException {
		int AccountNo;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the Acoount number to perform search operation ");
		AccountNo = sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankinfinite",
					"root","root");
			String cmd = "select *from Bank where AccountNo=?";
			PreparedStatement  pst = conn.prepareStatement(cmd);
			pst.setInt(1, AccountNo);
			pst.setInt(1, AccountNo);
			ResultSet res = pst.executeQuery();
			if(res.next()) {
				System.out.println("Name is : " + res.getString("FirstName"));
				System.out.println("LastName is " + res.getString("LastName"));
				System.out.println("City is " + res.getString("City"));
				System.out.println("State is " + res.getString("State"));
				System.out.println("The Amount is " + res.getInt("Amount"));
				System.out.println("Cheqfacil is " + res.getString("Cheqfacil"));
				System.out.println("AccountType is " + res.getString("AccountType"));
				System.out.println("Status is " + res.getString("Status"));
				System.out.println("the Date of the open is " + res.getString("Dateofopen"));
			}else {
				System.out.println("****The Records are not Found in the Table *****");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
