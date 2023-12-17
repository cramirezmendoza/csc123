package com.bankingApplication.CamilaR;

public class MainApp{

    public static void main(String[] args) {
        Bank bank = new Bank();
        UiManager uiManager = new UiManager(bank);

        boolean isRunning = true;
        while (isRunning) {
            uiManager.showMenu();
            int choice = uiManager.readUserInput();
            switch (choice) {
                case 1:
                    //open a Checking account
                	uiManager.OpenCheckingAccount();
                    break;
                case 2:
                    //open a Savings account
                    uiManager.OpenSavingsAccount();
                    break;
                case 3:
                    //list all accounts
                    uiManager.handleListAccounts();
                    break;
                case 4:
                    //show account statement
                    uiManager.AccountStatement();
                    break;
                case 5:
                    //deposit money
                    uiManager.Deposit();
                    break;
                case 6:
                    //withdraw money
                    uiManager.Withdraw();
                    break;
                case 7:
                    //close an account
                    uiManager.CloseAccount();
                    break;
                case 8:
                    isRunning = false; // Exit the loop and end the program
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
                    break;
            }
        }
    }

    
}
