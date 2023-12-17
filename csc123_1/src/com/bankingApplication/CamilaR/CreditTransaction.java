package com.bankingApplication.CamilaR;

public class CreditTransaction extends Transactions {
	public CreditTransaction(double amount, int transId) {
		super(amount, transId);
	}

	@Override
	public String getType() {
		return "Credit";
	}

}
