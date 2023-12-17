package com.bankingApplication.CamilaR;
public class DebitTransaction extends Transactions {

	public DebitTransaction(double amount, int transId) {
		super(amount, transId);
	}

	@Override
	public String getType() {
		return "Debit ";
	}
}
