package com.bankingApplication.CamilaR;

abstract public class Transactions {

	protected double amount;
	protected int transactionNumber;

	// Constructor
	public Transactions(double amount, int transId) {
		this.amount = amount;
		this.transactionNumber = transId;
	}

	// getter
	public double getAmount() {
		return amount;
	}

	public int getTransactionNumber() {
		return transactionNumber;
	}
	
	abstract public String getType();
}
