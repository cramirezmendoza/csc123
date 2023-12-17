package com.bankingApplication.CamilaR;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
	protected List<Transactions> transactions;
	protected String status;
	protected AccountHolder accountHolder;
	protected int accountNum;
	private int transId = 100;

	public Account(AccountHolder accountHolder, int accountNumber) {
		this.accountHolder = accountHolder;
		this.transactions = new ArrayList<>();
		this.status = "Open";
		this.accountNum = accountNumber;
	}

	public void closeAccount() {
		if (this.status.equals("Open")) {
			this.status = "Closed";
			System.out.println("Account closed, current blance is " + getBalance());
		}
	}

	public boolean isOpen() {
		return this.status.equals("Open");
	}

	protected int getNextTransactionId() {
		transId++;
		return transId;
	}
	
	abstract public boolean deposit(double amount);

	abstract public boolean withdraw(double amount);

	public double getBalance() {
		double balance = 0.0;
		for (Transactions t : transactions) {
			if (t instanceof CreditTransaction) {
				balance += t.getAmount();
			} else if (t instanceof DebitTransaction) {
				balance -= t.getAmount();
			}
		}
		return balance;
	}

	public List<Transactions> getTransactions() {
		return transactions;
	}

	public int getAccountNumber() {
		return accountNum;
	}

	abstract public String toString();

}
