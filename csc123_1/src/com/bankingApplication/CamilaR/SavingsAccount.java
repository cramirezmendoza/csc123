package com.bankingApplication.CamilaR;

public class SavingsAccount extends Account {

	public SavingsAccount(AccountHolder accountHolder, int accountNum) {
		super(accountHolder, accountNum);
	}

	public boolean deposit(double amount) {
			transactions.add(new CreditTransaction(amount, getNextTransactionId()));
			return true;
	}

	public boolean withdraw(double amount) {
		if (getBalance() >= amount) {
			transactions.add(new DebitTransaction(amount, getNextTransactionId()));
			return true;
		}
		
		System.out.println("Insufficient funds");
		return false;
	}

	@Override
	public String toString() {
		return String.valueOf(accountNum) + "(Savings) : " + accountHolder.toString() + " : " + String.format("%.2f%n", getBalance())+ " : Account " + status;
	}

}
