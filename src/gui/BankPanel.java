package gui;

import java.awt.GridLayout;

import javax.swing.JTextField;

import bank.Bank;

public class BankPanel extends javax.swing.JPanel{

	JTextField username, accountValue, accountUser;
	JTextField user1, user2, transferValue;
	CreateUserButton createUser;
	CreateAccountButton createAccount;
	SendMoneyButton sendMoney;
	
	JTextField bankstatus;
	
	JTextField[] empty;
	
	Bank b;
	
	public BankPanel(Bank b)
	{
		this.b = b;
		username = new JTextField(50);
		username.setToolTipText("Enter Firstname and Lastname, seperated by a single space");
		accountValue = new JTextField(50);
		accountValue.setToolTipText("Enter initial Account Value");
		
		accountUser = new JTextField(50);
		accountUser.setToolTipText("Enter customers user Name");
		
		user1 = new JTextField(50);
		user1.setToolTipText("Enter user who will pay the money");
		user2 = new JTextField(50);
		user2.setToolTipText("Enter user who will get the money");
		
		transferValue = new JTextField(50);
		transferValue.setToolTipText("Enter sum to be transferred");
		
		bankstatus = new JTextField(50);
		bankstatus.setEditable(false);
		
		empty = new JTextField[3];
		for (int i = 0; i < empty.length ; i++)
		{
			empty[i] = new JTextField(50);
			empty[i].setEditable(false);
			empty[i].setToolTipText("empty");
		}
		
		
		createUser = new CreateUserButton(b,this);
		createAccount = new CreateAccountButton(b,this);
		sendMoney = new SendMoneyButton(b,this);
		
		this.setLayout(new GridLayout(3,3));
		
		this.add(username);
		this.add(empty[0]);
		this.add(empty[1]);
		this.add(createUser);
		
		this.add(accountUser);
		this.add(accountValue);
		this.add(empty[2]);
		this.add(createAccount);
		
		this.add(user1);
		this.add(user2);
		this.add(transferValue);
		this.add(sendMoney);
		
		//this.add(bankstatus);
		
		this.setVisible(true);
	}
	
	public String getUsername()
	{
		return username.getText();
	}
	
	public String getAccountUser()
	{
		return accountUser.getText();
	}
	
	
	public String getAccountValue()
	{
		return accountValue.getText();
	}
	
	public String getUser1()
	{
		return user1.getText();
	}
	
	public String getUser2()
	{
		return user2.getText();
	}
	
	public String getTransferSum()
	{
		return transferValue.getText();
	}
	
	public void modelChanged()
	{
		// call this method whenever the model data has changed
		String t = new String("");
		
		bankstatus.setText(t);
		
		repaint();
	}
	
	
}
