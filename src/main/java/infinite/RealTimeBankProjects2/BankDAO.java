package infinite.RealTimeBankProjects2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BankDAO {
	Connection connection;
	PreparedStatement pst;
//	six task is to close or show inactive account 
	public String closeAccount(int AccountNo) throws ClassNotFoundException, SQLException {
		Bank accountfound = searchAccount(AccountNo);
		if(accountfound!=null) {
			connection = ConnectionHelper.getConnection();
			String cmd = "update Bank set Status='inactive' where AccountNo=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, AccountNo);
			pst.executeUpdate();
			return "Account Deactivated Successfully";
		}
		return "Account Numnber Does not Exists";
	}
	
	
//	fifth task is to withdraw the money from the account 
	public String WithDrawAmount(int AccountNo,int drawAmount) throws ClassNotFoundException, SQLException {
		Bank accountFBank = searchAccount(AccountNo);
		if(accountFBank!=null) {
			connection = ConnectionHelper.getConnection();
			int balanaceAmount = accountFBank.getAmount();
			if(balanaceAmount- drawAmount>=1000){
				String cmd = "update Bank set Amount=? where AccountNo=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, drawAmount);
				pst.setInt(2, AccountNo);
				pst.executeUpdate();
				cmd = "insert into Trans(AccountNo,TransAmount,TransType)values (?,?,?)";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, AccountNo);
				pst.setInt(2, drawAmount);
				pst.setString(3, "Debited");
				pst.executeUpdate();
				return "Amount is debited from the Account";
			}else {
			return "Amount is not suffiecient in your Account ...";
			}
		}
		return "Account number does not Exist";
	}
//	fourth task is to deposite Money in to the specific Account
	public String depositeAmount(int AccountNo,int DepoAmount ) throws ClassNotFoundException, SQLException {
		Bank AccountFound = searchAccount(AccountNo);
		if(AccountFound!=null) {
			connection = ConnectionHelper.getConnection();
			String cmd = "update Bank set Amount=Amount+? where AccountNo=? ";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, DepoAmount);
			pst.setInt(2, AccountNo);
			pst.executeUpdate();
			cmd = "insert into Trans(AccountNo,TransAmount,TransType)values(?,?,?)";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, AccountNo);
			pst.setInt(2, DepoAmount);
			pst.setString(3, "Credited");
			pst.executeUpdate();
			return "******the Amount is deposited in to Bank ******";
		}
		return "Account does not Exist *****";
	}
//	third task is  to search the account from the bank table 
	public Bank searchAccount(int AccountNo) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select *from Bank where AccountNo=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, AccountNo);
		ResultSet res = pst.executeQuery();
		Bank bank = null;
		if(res.next()) {
			bank = new Bank();
			bank.setAccountNo(res.getInt("AccountNo"));
			bank.setFirstName(res.getString("FirstName"));
			bank.setLastName(res.getString("LastName"));
			bank.setCity(res.getString("City"));
			bank.setState(res.getString("State"));
			bank.setAmount(res.getInt("Amount"));
			bank.setCheqFacil(res.getString("CheqFacil"));
			bank.setAccountType(res.getString("AccountType"));
		}
		return bank;
	}
	
//	Secondly we have to create account in a Bank;
	public String createAccount(Bank bank) throws ClassNotFoundException, SQLException {
		int accno = generateAccountNo();
		bank.setAccountNo(accno);
		String cmd = "insert into Bank(AccountNo,FirstName,LastName,City,State,"
				+ "Amount, Cheqfacil,AccountType) values(?,?,?,?,?,?,?,?)";
		connection = ConnectionHelper.getConnection();
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, accno);
		pst.setString(2, bank.getFirstName());
		pst.setString(3, bank.getLastName());
		pst.setString(4, bank.getCity());
		pst.setString(5, bank.getState());
		pst.setInt(6, bank.getAmount());
		pst.setString(7,bank.getCheqFacil());
		pst.setString(8, bank.getAccountType());
		pst.executeUpdate();
		return "****** Account is created successFully ******"; 
	}

	
	//	first we have to generate the account number 
	public int generateAccountNo() throws ClassNotFoundException, SQLException {
		String cmd = "Select case when max(AccountNo) is null then 1 "+
	"else max(AccountNo) +1 End accno from Bank";
		connection = ConnectionHelper.getConnection();
		pst = connection.prepareStatement(cmd);
		ResultSet res = pst.executeQuery();
		res.next();
		int accno = res.getInt("accno");
		return accno;
		
	}

}
