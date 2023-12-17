package com.bankingApplication.CamilaR;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class UiManager {
	private Scanner scanner;
	private Bank bank; // Add a reference to the Bank class

	public UiManager(Bank bank) { // Update constructor to accept a Bank instance
		this.bank = bank;
		this.scanner = new Scanner(System.in);
	}

	public void showMenu() {
		System.out.println("1 - Open a Checking account");
		System.out.println("2 - Open Saving Account");
		System.out.println("3 - List Accounts");
		System.out.println("4 - Account Statement");
		System.out.println("5 - Deposit funds");
		System.out.println("6 - Withdraw funds");
		System.out.println("7 - Close an account");
		System.out.println("8 - Exit\n");

	}

	public int readUserInput() {
		System.out.print("Please select an option: ");
		while (!scanner.hasNextInt()) {
			scanner.next(); 
			System.out.print("Please select a valid option: ");
		}
		int input = scanner.nextInt(); 
		scanner.nextLine(); 
		return input;
	}

	// methods
	public void OpenCheckingAccount() {
		System.out.println("Opening a new Checking Account...");

		// Gather user information
		System.out.print("Enter first name: ");
		String firstName = scanner.nextLine();

		System.out.print("Enter last name: ");
		String lastName = " " + scanner.nextLine();

		System.out.print("Enter Date of Birth (yyyy-mm-dd): ");
		String dobStr = scanner.nextLine();
		LocalDate dob = LocalDate.parse(dobStr); 

		System.out.print("Enter Social Security Number (SSN): ");
		String ssn = scanner.nextLine();

		System.out.print("Enter Address: ");
		String address = scanner.nextLine();

		
		AccountHolder holder = new AccountHolder(firstName, lastName, dob, ssn, address);

		double overdraftLimit = 0;
		if (holder.getAgeInYears() >= 18) {
			System.out.print("Enter overdraft limit: ");
			while (!scanner.hasNextDouble()) {
				scanner.next(); 
				System.out.print("Please enter a valid amount: ");
			}
			overdraftLimit = scanner.nextDouble();
			scanner.nextLine(); 
		}

		
		int accountNum = bank.openAccount(holder, overdraftLimit);

		System.out.println("Thank you, the account number is: " + accountNum + ".\n");
	}

	public void OpenSavingsAccount() {
		System.out.println("Opening a new Savings Account...");

	
		System.out.print("Enter first name: ");
		String firstName = scanner.nextLine();

		System.out.print("Enter last name: ");
		String lastName = " " + scanner.nextLine();

		LocalDate dob = null;
		while (dob == null) {
			System.out.print("Enter Date of Birth (yyyy-mm-dd): ");
			String dobStr = scanner.nextLine();
			try {
				dob = LocalDate.parse(dobStr);
			} catch (DateTimeParseException e) {
				System.out.println("That's not a valid date. Please try again.");
			}
		}

		System.out.print("Enter Social Security Number (SSN): ");
		String ssn = scanner.nextLine();

		
		AccountHolder holder = new AccountHolder(firstName, lastName, dob, ssn, null);

		
		int accountNum = bank.openAccount(holder);

		System.out.println("Thank you, the account number is: " + accountNum + ".\n");
	}

	public void handleListAccounts() {
		System.out.println("Listing all accounts...");

		List<Account> accounts = bank.listAccounts();
		if (accounts.isEmpty()) {
			System.out.println("No accounts found.");
		} else {
			for (Account account : accounts) {
				
				System.out.println(account.toString());
			}
			System.out.println();
		}
	}

	public void AccountStatement() {
		System.out.println("Fetching account statement...");
		System.out.print("Enter the account number: ");
		String accountNumber = scanner.nextLine();

		Account account = bank.getAccount(Integer.parseInt(accountNumber));
		if (account != null) {
			List<Transactions> transactions = account.getTransactions();
			if (transactions.isEmpty()) {
				System.out.println("No transactions found for this account.");
			} else {
				System.out.println("Account Statement for account number: " + accountNumber);
				for (Transactions transaction : transactions) {
					String type = transaction.getType();
					String transactionNumber = String.valueOf(transaction.getTransactionNumber()); 
			
					System.out.printf("%s : %s : %.2f%n", transactionNumber, type, transaction.getAmount());
				}
				System.out.printf("Balance: %.2f%n", account.getBalance());
			}
		} else {
			System.out.println("Account not found");
		}
	}

	public void Deposit() {
		System.out.println("Enter account number: ");
		int accountNumberInt = scanner.nextInt();
		System.out.print("Enter deposit amount: ");
		double amount = scanner.nextDouble();
		scanner.nextLine(); 
		bank.deposit(accountNumberInt, amount); 
	}

	public void Withdraw() {
		System.out.println("Withdraw Funds");
		System.out.print("Enter account number: ");
		int accountNumberInt = scanner.nextInt();
		scanner.nextLine(); 
		System.out.print("Enter the withdrawal amount: ");
		double amount = scanner.nextDouble();
		scanner.nextLine(); 
		bank.withdraw(accountNumberInt, amount); // Use String for the account number
	}

	public void CloseAccount() {
		System.out.println("Enter account number to close: ");
		int accountNumberInt = scanner.nextInt();
		scanner.nextLine(); //Read the account number as an integer
		System.out.println(); 
		bank.closeAccount(accountNumberInt); // Call closeAccount with a String account number
	}

	public void handleExit() {
		System.out.println("Exiting the application...");
		
	}
}
