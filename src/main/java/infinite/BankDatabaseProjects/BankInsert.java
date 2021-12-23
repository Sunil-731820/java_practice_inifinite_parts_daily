package infinite.BankDatabaseProjects;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BankInsert {
	public static void main(String[] args) throws SQLException {
		int AccountNo,Amount;
		String FirstName,LastName,City,State,CheqFacil,AmountType,Status,AccountType = "active";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Account Number\n ");
		AccountNo = sc.nextInt();
		System.out.println("Enter the FirstName\n ");
		FirstName = sc.next();
		System.out.println("Enter the LastName\n ");
		LastName = sc.next();
		System.out.println("Enter the city \n");
		City = sc.next();
		System.out.println("Enter the STate\n");
		State = sc.next();
		System.out.println("Enter the Amount \n");
		Amount = sc.nextInt();
		System.out.println("Enter the CheqFacial\n");
		CheqFacil = sc.next();
		System.out.println("Enter the Amount type\n");
		AmountType = sc.next();
		System.out.println("Enter the Status \n");
		Status = sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankinfinite",
					"root","root");
			
			String cmd = "insert into Bank(AccountNo,FirstName,LastName,City,State,Amount,CheqFacil,AccountType,Status) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(cmd);
			pst.setInt(1,AccountNo);
			pst.setString(2, FirstName);
			pst.setString(3, LastName);
			pst.setString(4, City);
			pst.setString(5, State);
			pst.setInt(6, Amount);
			pst.setString(7, CheqFacil);
			pst.setString(8, AccountType);
			pst.setString(9, Status);
			pst.executeUpdate();
			System.out.println("********The Records are added successfully into the table *******");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
