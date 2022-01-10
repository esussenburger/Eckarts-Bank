package gui;

import javax.swing.JButton;

import bank.Bank;
import bank.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccountButton extends JButton implements ActionListener{

	Bank b;
	BankPanel bp;
	
	public CreateAccountButton(Bank b,BankPanel bp)
	{
		this.b = b;
		this.bp = bp;
		
		this.setText("create Account");
		this.addActionListener(this);
		
		this.setToolTipText("click to create Account");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String accountUser = bp.getAccountUser();
		String accountValue = bp.getAccountValue();
		
		if (accountUser.isEmpty())
		{
			System.err.println("Error. No User Name entered!");
			return;
		}
		if (accountUser.contains(" "))
		{
			System.err.println("Error. Please Enter user ID, not First and LastName!");
			return;
		}
		
		User u = b.getUser(accountUser);
		
		if (accountValue.isEmpty())
		{
			u.createAccount(accountUser, 0);
			System.out.println("Creating Account for User: "+u.getCustomerID());
			System.out.println("Initial Account Value: 0");
			return;
		}
		
		int aValue = Integer.parseInt(accountValue);
		
		if (aValue < 0)
		{
			System.err.println("Warning. Initial Amount cannot be negative. Changed to 0 by system.");
			aValue = 0;
		}
		
		u.createAccount(accountUser, aValue);
		System.out.println("Creating Account for User: "+u.getCustomerID());
		System.out.println("Initial Account Value: "+aValue);
		System.out.println();
		
		System.out.println(b.toString());
	}

}
