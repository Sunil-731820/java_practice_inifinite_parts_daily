package infinite.BankDatabaseProjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankShowAll {
	public static void main(String[] args) throws SQLException {
		int AccountNo,Amount;
		String FirstName , LastName,City,State,CheqFacil,AmountType,Status,AccountType = "active";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankinfinite",
					"root","root");
			String cmd = "select *from Bank";
			PreparedStatement pst = conn.prepareStatement(cmd);
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				System.out.println("Account Number is " + res.getInt("AccountNo"));
				System.out.println("first Name is " + res.getString("FirstName"));
				System.out.println("The LastName is " + res.getString("LastName"));
				System.out.println("City is " + res.getString("City"));
				System.out.println("State is " + res.getString("State"));
				System.out.println("Amount is " + res.getInt("Amount"));
				System.out.println("Cheqfacial is "+ res.getString("CheqFacil"));
				System.out.println("The AccountType is " + res.getString("AccountType"));
				System.out.println("Status is " + res.getString("Status"));
				System.out.println("Dateofopen is " + res.getString("Dateofopen"));
				System.out.println("-----------------------------------------------------");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
