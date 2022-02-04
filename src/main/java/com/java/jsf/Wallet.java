package com.java.jsf;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Wallet {
	
	private int cusId;
	private int walId;
	private double walAmount;
	private WalletSource walSource;
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public int getWalId() {
		return walId;
	}
	public void setWalId(int walId) {
		this.walId = walId;
	}
	public double getWalAmount() {
		return walAmount;
	}
	public void setWalAmount(double walAmount) {
		this.walAmount = walAmount;
	}
	public WalletSource getWalSource() {
		return walSource;
	}
	public void setWalSource(WalletSource walSource) {
		this.walSource = walSource;
	}
	
	static CustomerDAO dao;
	static {
		dao = new CustomerDAO();
	}
	
	public Wallet[] showWallet() throws ClassNotFoundException, SQLException {
		return dao.showWallet();
	}
	
	

}
