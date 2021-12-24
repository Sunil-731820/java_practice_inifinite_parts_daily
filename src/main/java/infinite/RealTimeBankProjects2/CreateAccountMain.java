package infinite.RealTimeBankProjects2;

import java.sql.SQLException;
import java.util.Scanner;

public class CreateAccountMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		BankDAO dao = new BankDAO();
		Bank bank = new Bank();
		System.out.println("Enter the FirstName here \n");
		bank.setFirstName(sc.next());
		System.out.println("Enter the LastName here\n");
		bank.setLastName(sc.next());
		System.out.println("Enter the City here\n ");
		bank.setCity(sc.next());
		System.out.println("Enter the State here\n");
		bank.setCity(sc.next());
		System.out.println("Enter the Amount here\n ");
		bank.setAmount(sc.nextInt());
		System.out.println("Enter the Cheqfacil Here\n ");
		bank.setCheqFacil(sc.next());
		System.out.println("Enter the account Type here\n ");
		bank.setAccountType(sc.next());
		System.out.println(dao.createAccount(bank));
		
	}

}
