package bank;

public class TransactionHandler {

	Bank bank;
	
	public TransactionHandler(Bank b)
	{
		this.bank = b;
	}
	
	public void sendMoney(String userIDA, String userIDB, int cash)
	/* this will pick the first account with sufficient funds from user A */
	{
		User a = bank.getUser(userIDA);
		User b = bank.getUser(userIDB);
		
		a.getAccount(cash).deduct(cash);
		b.getAccount().increase(cash);
		
		System.out.println("Transaction complete");
		
	}
	
	
	public void sendMoney(User A, User B, int cash)
	/* this will pick the first account with sufficient funds from user A */
	{
		A.getAccount(cash).deduct(cash);
		B.getAccount().increase(cash);
		
		System.out.println("Transaction complete");
	}
	
	public void sendMoney(Account A, Account B, int cash)
	/* this will use two specific accounts */
	{
		
	}
}
