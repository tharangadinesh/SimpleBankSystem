package com.diligroup.simplebanksystem.constant;

public enum TransactionType {

	DEPOSIT(0),
	WITHDRAW(1);

	private int id;

	private TransactionType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
