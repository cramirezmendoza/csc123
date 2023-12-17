package com.bankingApplication.CamilaR;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Bank {
	private Map<Integer, Account> accounts; // Map to keep track of accounts by account number
	private int nextId = 1000;

	public Bank() {
		this.accounts = new HashMap<>();
	}

	public int openAccount(AccountHolder holder, double overdraftLimit) {
		Integer accountNum = genUniqueAcctNum();
		Account newAccount = new CheckingAccount(holder, accountNum, overdraftLimit);

		accounts.put(accountNum, newAccount);
		return accountNum;
	}

	public int openAccount(AccountHolder holder) {
		Integer accountNum = genUniqueAcctNum();
		Account newAccount = new SavingsAccount(holder, accountNum);
		accounts.put(accountNum, newAccount);

		return accountNum;
	}

	private Integer genUniqueAcctNum() {
		nextId++;
		return Integer.valueOf(nextId);
	}

	public boolean closeAccount(Integer accountNumber) {
		Account accountToClose = accounts.get(accountNumber); // Retrieve the account from the map
		if (accountToClose != null) {
			accountToClose.closeAccount();
			return true;
		}
		System.out.println("Account not found");
		return false;

	}

	public boolean deposit(int accountNumber, double amount) {
		if (amount <= 0) {
			return false;
		}

		Account account = accounts.get(accountNumber);
		if (account != null) {
			if (account.deposit(amount)) {
				System.out.printf("Deposit Successful, the new balance is: %.2f%n\n", account.getBalance());
				return true;
			}
			System.out.printf("Deposit failed, the balance is: %.2f%n\n", account.getBalance());
		} else if (account == null) {
			System.out.println("Account not found");
		}
		return false;
	}

	public boolean withdraw(int accountNumber, double amount) {
		if (amount <= 0) {
			return false;
		}

		Account account = accounts.get(accountNumber);
		if (account != null) {
			if(account.withdraw(amount)) {
				System.out.printf("Withdrawal Successful, the new balance is: %.2f%n\n", account.getBalance());
				return true;
			}
			
			System.out.printf("Withdrawal failed, the balance is: %.2f%n\n", account.getBalance());
		} else if (account == null) {
			System.out.println("Account not found");
		}
		return false;
	}

	public Account getAccount(int accountNumber) {
		return accounts.get(accountNumber);
	}

	public List<Account> listAccounts() {
		return new ArrayList<>(accounts.values());
	}

}
