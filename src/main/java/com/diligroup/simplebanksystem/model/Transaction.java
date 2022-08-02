package com.diligroup.simplebanksystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.diligroup.simplebanksystem.constant.TransactionType;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToMany(targetEntity = Account.class)
	private Account account;

	private TransactionType transactionType;

	private String description;

	private double amount;

	private double balance;

	public Transaction(Account account, double amount) {
		super();
		this.account = account;
		this.amount = amount;
	}

	public Transaction(Account account, TransactionType transactionType, String description, double amount,
			double balance) {
		super();
		this.account = account;
		this.transactionType = transactionType;
		this.description = description;
		this.amount = amount;
		this.balance = balance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
