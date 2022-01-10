package bank;
import java.util.ArrayList;

public class User {

	String customerID, firstname, lastname;
	ArrayList<Account> accounts;
	
	public User(String cID, String firstname, String lastname)
	{
		this.customerID = cID;
		this.firstname = firstname;
		this.lastname = lastname;
		
		accounts = new ArrayList<Account>();
		
	}
	
	public Account getAccount(int cash)
	/* returns an account with at least "cash" in it */
	{
		for (Account a:accounts)
		{
			if (a.cash >= cash)
				return a;
		}
		
		System.out.print("Error! No Account has enough funds");
		
		return accounts.get(0);
	}
	
	public Account getAccount()
	/* returns the first account, creates empty account if needed*/
	{
		if (accounts.size()==0)
		{
			createAccount(customerID,0);
			System.out.println("User had no Account yet. Created empty Account by default.");
		}
		return accounts.get(0);
	}
	
	public String toString()
	{
		String acc = "";
		
		for (Account a:accounts)
		{
			acc += ","+a.toString();
		}
		return customerID+","+firstname+","+lastname+acc;
	}
	
	public User createUser(String cID, String firstname, String lastname)
	{
		return new User(cID,firstname,lastname);
	}
	
	public void createAccount(String cID,int cash)
	{
		accounts.add(new Account(this.customerID,cash));
	}
	
	public String getCustomerID()
	{
		return customerID;
	}
	
	public boolean evaluateConsistency()
	{
		boolean ret = true;
		
		for (Account a:accounts)
		{
			if (this.customerID!=a.custID)
				ret = false;
		}
		
		return ret;
	}
}
