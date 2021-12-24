package infinite.RealTimeBankProjects2;

import java.sql.SQLException;
import java.util.Scanner;

public class WithDrawAmountMain {
	public static void main(String[] args) {
		int AccountNo,drawAmount;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Account Number here ");
		AccountNo = sc.nextInt();
		System.out.println("Enter the Amount to Withdraw ");
		drawAmount = sc.nextInt();
		try {
			System.out.println(new BankDAO().WithDrawAmount(AccountNo, drawAmount));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
