package gui;

import javax.swing.JButton;

import bank.Bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateUserButton extends JButton implements ActionListener {
	
	Bank b;
	BankPanel bp;
	
	public CreateUserButton(Bank b, BankPanel bp)
	{
		this.setText("create User");
		this.addActionListener(this);
		
		this.b = b;
		this.bp = bp;
		
		this.setToolTipText("click to create User");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String firstName, lastName, userID;
		
		String fieldValue = bp.getUsername();
		
		if (fieldValue.isEmpty())
		{
			System.err.println("Error. No User Name entered!");
			return;
		}
		if (!fieldValue.contains(" "))
		{
			System.err.println("Error. Please Enter First and Last Name!");
			return;
		}
		
		
		
		String[] values = fieldValue.split(" ");
		
		firstName = values[0];
		lastName = values[1];
		userID = firstName.charAt(0)+lastName;
		
		b.createUser(userID, firstName, lastName);
		System.out.println("Creating User: \n"+"User ID = "+userID+"\n"+"First Name = "+firstName+"\n"+"Last Name = "+lastName+"\n");
		
		System.out.println(b.toString());
		
	}

}
