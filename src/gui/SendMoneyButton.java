package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import bank.Bank;
import bank.User;

public class SendMoneyButton extends JButton implements ActionListener{

	Bank b;
	BankPanel bp;
	
	public SendMoneyButton(Bank b,BankPanel bp)
	{
		this.b = b;
		this.bp = bp;
		
		this.setText("Send Money");
		this.addActionListener(this);
		
		this.setToolTipText("click to send Money from User A to User B");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String user1,user2,money;
		
		user1 = bp.getUser1();
		user2 = bp.getUser2();
		money = bp.getTransferSum();
		
		
		if (user1.isEmpty()||user1.isEmpty())
		{
			System.err.println("Error. No User Name entered!");
			return;
		}
		if (user1.contains(" ")||user1.contains(" "))
		{
			System.err.println("Error. Please Enter user ID, not First and LastName!");
			return;
		}
		
		if (money.isEmpty())
		{
			System.err.println("Error. No Transfer Sum specified: ");
			return;
		}
		
		if (money.startsWith("-"))
		{
			System.err.println("Error. Negative Money Transfer is prohibited: ");
			return;
		}
		
		int transferSum = Integer.parseInt(money);
		
		User u1 = b.getUser(user1);
		User u2 = b.getUser(user2);
		
		b.sendMoney(u1, u2, transferSum);
		
		System.out.println("Sending Money from "+u1.getCustomerID()+" to "+u2.getCustomerID());
		System.out.println("Transferred Value is "+transferSum);
		
		
		System.out.println(b.toString());
		
	}
}
