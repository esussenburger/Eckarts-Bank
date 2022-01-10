package bank;
public class Account {

	String custID;
	int cash;
	
	public Account()
	{
		
	}
	
	public Account(String cID, int cash)
	{
		this.cash = cash;
		this.custID = cID;
	}
	
	public Account createAccount(String customerID, int amountofcash)
	{
		return new Account(customerID, amountofcash);
	}
	
	public Account createAccount(String customerID)
	{
		return new Account(customerID, 0);
	}
	
	public void deduct(int cash)
	{
		this.cash -= cash;
	}
	
	public void increase(int cash)
	{
		this.cash += cash;
	}
	
	public String toString()
	{
		return ","+cash;
	}
}
