package infinite.RealTimeBankProjects2;

import java.sql.SQLException;
import java.util.Scanner;

public class CloseAccountMain {
	public static void main(String[] args) {
		int AccountNo;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Account Number to be closed ");
		AccountNo = sc.nextInt();
		try {
			System.out.println(new BankDAO().closeAccount(AccountNo));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
