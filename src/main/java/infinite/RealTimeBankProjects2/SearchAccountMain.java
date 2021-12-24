package infinite.RealTimeBankProjects2;

import java.sql.SQLException;
import java.util.Scanner;

public class SearchAccountMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int AccountNo;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Account Number Here");
		AccountNo = sc.nextInt();
		Bank bank = new BankDAO().searchAccount(AccountNo);
		if(bank!=null) {
			System.out.println(bank);
		}else {
			System.out.println("***** The Records Does Not Exist in the Table ******");
		}
	}
}
