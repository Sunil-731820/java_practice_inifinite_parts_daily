package com.java.jsf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
	
	Connection connection;
	PreparedStatement pst ;
	
	public Customer[] showCustomer() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select *from customer";
		pst = connection.prepareStatement(cmd);
		ResultSet res = pst.executeQuery();
		List<Customer> customerList = new ArrayList<Customer>();
		Customer customer = null;
		while(res.next()) {
			customer = new Customer();
			customer.setCusId(res.getInt("CUS_ID"));
			customer.setCusname(res.getString("CUS_NAME"));
			customer.setPhoneNum(res.getString("CUS_PHN_NO"));
			customer.setUserName(res.getString("CUS_USERNAME"));
			customer.setPassWord(res.getString("CUS_PASSWORD"));
			customer.setEmail(res.getString("CUS_EMAIL"));
			customerList.add(customer);
		}
		return customerList.toArray(new Customer[customerList.size()]);
		
	}
	
	public Vendor[] showVendor() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select *from vendor";
		pst = connection.prepareStatement(cmd);
		ResultSet res = pst.executeQuery();
		List<Vendor> vendorList = new ArrayList<Vendor>();
		Vendor vendor = null;
		while(res.next()) {
			vendor = new Vendor();
			vendor.setVenId(res.getInt("VEN_ID"));
			vendor.setVenname(res.getString("VEN_NAME"));
			vendor.setPhoneNum(res.getString("VEN_PHN_NO"));
			vendor.setUserName(res.getString("VEN_USERNAME"));
			vendor.setPassWord(res.getString("VEN_PASSWORD"));
			vendor.setEmail(res.getString("VEN_EMAIL"));
			vendorList.add(vendor);
			
		}
		return vendorList.toArray(new Vendor[vendorList.size()]);
		
	}

	
	public Wallet[] showWallet() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select *from wallet";
		pst = connection.prepareStatement(cmd);
		ResultSet res = pst.executeQuery();
		List<Wallet> walletList = new ArrayList<Wallet>();
		Wallet wallet = null;
		while(res.next()) {
			wallet = new Wallet();
			wallet.setCusId(res.getInt("CUS_ID"));
			wallet.setWalId(res.getInt("WAL_ID"));
			wallet.setWalAmount(res.getDouble("WAL_AMOUNT"));
			wallet.setWalSource(WalletSource.valueOf(res.getString("WAL_SOURCE")));
			walletList.add(wallet);
			
		}
		return walletList.toArray(new Wallet[walletList.size()]);
		
	}

}
