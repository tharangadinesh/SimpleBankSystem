package com.diligroup.simplebanksystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String user;

	@Column(unique = true)
	private String acccountNo;

	private String currency;

	private double balance;

	public Account() {

	}

	public Account(String user, String acccountNo, String currency, double balance) {
		super();
		this.user = user;
		this.acccountNo = acccountNo;
		this.currency = currency;
		this.balance = balance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getAcccountNo() {
		return acccountNo;
	}

	public void setAcccountNo(String acccountNo) {
		this.acccountNo = acccountNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
