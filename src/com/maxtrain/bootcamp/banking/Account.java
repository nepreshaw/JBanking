package com.maxtrain.bootcamp.banking;

public class Account {
	
	//this would be called a field in .net, like a property without get; set;
	//not accessible outside of the class because private
	//create two methods for each property 1) Get method which is public 2) Setter method
	private int accountNo;
	private String description;
	private double balance;
	private static int nextAccountNo = 1;
	
	public void deposit(double amount) throws Exception  {
		if (amount <= 0) {
			throw new Exception("amount must be greater than zero");
		}
		//double sum = amount + getBalance();
		setBalance(getBalance() + amount);
	}
	
	public void withdraw(double amount) throws Exception {
		if (amount <= 0) {
			throw new Exception("amount must be greater than zero");
		} 
		if (amount > getBalance()) {
			throw new Exception("insufficient funds");
		}
		setBalance(getBalance() - amount);
	}
	
	public String toString() {
		var message = "accountNo = " + this.getAccountNo() + "\n"
					+ "description = " + this.getDescription() + "\n"
					+ "balance = " + this.getBalance() + "\n";
		return message;
	}
	
	public Account(String description) {
		this.setDescription(description);
		this.setAccountNo(this.nextAccountNo++);
		try {
		this.setBalance(0);
		} catch(Exception ex){
			
		}
	}
	
	public void transfer(double amount, Account toAccount) throws Exception {	
		this.withdraw(amount);
		toAccount.deposit(amount);
	}
	
	public double getBalance() {
		return balance;
	}
	
	public Account() {}

	private void setBalance(double balance) throws Exception {
		if (balance < 0) {
			throw new Exception("balance must be greater than or equal to zero");
		}
		this.balance = balance;
	}

	//getter, or get method
	public int getAccountNo() {
		
		return accountNo;
	}
	
	//setter
	//this is how an outside class can change the value of the variable
	//property is the one with .this on it
	protected void setAccountNo(int accountNo) {
		
		this.accountNo = accountNo;
	}
		

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
}
