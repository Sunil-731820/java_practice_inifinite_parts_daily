package infinite.RealTimeBankProjects2;

import java.sql.SQLException;
import java.util.Scanner;

public class DepositeAmountMain {
	public static void main(String[] args) {
		int AccountNo,depoAmount;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Account number here ");
		AccountNo = sc.nextInt();
		System.out.println("Enter the amount to be Deposited in your account");
		depoAmount = sc.nextInt();
		try {
			System.out.println(new BankDAO().depositeAmount(AccountNo, depoAmount));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
