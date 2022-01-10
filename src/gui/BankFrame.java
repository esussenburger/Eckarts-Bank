package gui;

import javax.swing.JFrame;

import bank.Bank;

public class BankFrame extends JFrame {
	
	BankPanel bp;
	
	Bank b;
	
	public BankFrame()
	{
		super("Eckarts Banking Software (v 1.0)");
		this.setSize(800,400);
		this.setLocation(200,200);
		
		b = new Bank("Volksbank");
		
		bp = new BankPanel(b);
		this.add(bp);
		
		
		
		
		this.setVisible(true);
	}

}
