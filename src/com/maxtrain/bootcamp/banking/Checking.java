package com.maxtrain.bootcamp.banking;

public class Checking extends Account {
	
	private int checkCounter;
	
	public Checking(String description) {
		super(description);
		this.setCheckCounter(0);
	}
	
	public String toString() {
		return super.toString() + "\n" + "checks= " + checkCounter;
	}
	
	public int getCheckCounter() {
		return checkCounter;
	}

	private void setCheckCounter(int checkCounter) {
		this.checkCounter = checkCounter;
	}
	
	

	public void writeCheck(int checkNo, double checkAmount) throws Exception{
		withdraw(checkAmount);
		checkCounter++;
		
	}
}
