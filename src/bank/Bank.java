package bank;
import java.util.ArrayList;

public class Bank {

	ArrayList<User> users;
	String name;
	
	TransactionHandler t;
	
	public Bank(String name)
	{
		
		this.name=name;
		
		users = new ArrayList<User>();
		
		t = new TransactionHandler(this);
		
		this.createUser("default", "Default", "Default");
		
	}
	
	public void createUser(String userID, String firstname, String lastname)
	{
		users.add(new User(userID,firstname,lastname));
	}
	
	public ArrayList<User> getUsers()
	{
		return users;
	}
	
	public User getUser(String userID)
	{
		for (User u:users)
		{
			if (userID.equalsIgnoreCase(u.customerID))
			return u;
		}
		System.err.println("CAUTION! NO USER FOUND! RETURNING DEFAULT USER!");
		
		return users.get(0);
	}
	
	public String toString()
	{
		String ret = "Printing Info for "+name+"\n";
		
		for (User u:users)
		{
			ret += u.toString()+"\n";
		}
		
		return ret;
	}

	public void sendMoney(String userIDA, String userIDB, int cash) {
		t.sendMoney(userIDA, userIDB, cash);
	}
	public void sendMoney(User A, User B, int cash) {
		t.sendMoney(A, B, cash);
	}
}
