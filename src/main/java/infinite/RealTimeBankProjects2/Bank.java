package infinite.RealTimeBankProjects2;

public class Bank {
	private int AccountNo ;
	private String FirstName;
	private String LastName;
	private String City;
	private String State;
	private int Amount;
	private String CheqFacil;
	private String AccountType;
	public int getAccountNo() {
		return AccountNo;
	}
	public void setAccountNo(int accountNo) {
		AccountNo = accountNo;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public String getCheqFacil() {
		return CheqFacil;
	}
	public void setCheqFacil(String cheqFacil) {
		CheqFacil = cheqFacil;
	}
	public String getAccountType() {
		return AccountType;
	}
	public void setAccountType(String accountType) {
		AccountType = accountType;
	}
	@Override
	public String toString() {
		return "Bank [AccountNo=" + AccountNo + ", FirstName=" + FirstName + ", LastName=" + LastName + ", City=" + City
				+ ", State=" + State + ", Amount=" + Amount + ", CheqFacil=" + CheqFacil + ", AccountType="
				+ AccountType + "]";
	}
	
	

}
