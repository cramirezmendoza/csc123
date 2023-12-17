package com.bankingApplication.CamilaR;

public class CheckingAccount extends Account {
	private double overdraftLimit;

	public CheckingAccount(AccountHolder accountHolder, int accountNum, double overdraftLimit) {
		super(accountHolder, accountNum);
		this.overdraftLimit = overdraftLimit;
	}

	public boolean deposit(double amount) {
			if (isOpen() || !isOpen() && amount == -getBalance()) {
				transactions.add(new CreditTransaction(amount, getNextTransactionId()));
				return true;
			}
		return false;
	}

	public boolean withdraw(double amount) {
		if (getBalance() + overdraftLimit >= amount) {
			transactions.add(new DebitTransaction(amount, getNextTransactionId()));
			return true;
		} else {
			System.out.println("Insufficient funds");
		}
		return false;
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	@Override
	public String toString() {
		return String.valueOf(accountNum) + "(Checking) : " + accountHolder.toString() + " : "
				+ String.format("%.2f%n", getBalance()) + " : Account " + status;
	}

}
