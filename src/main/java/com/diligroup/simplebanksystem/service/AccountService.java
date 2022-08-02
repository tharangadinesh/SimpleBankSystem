package com.diligroup.simplebanksystem.service;

import com.diligroup.simplebanksystem.model.Account;

public interface AccountService {

	Account deposit(String accountNo, double amount);

	Account withdraw(String accountNo, double amount);

	Account createAccount(String userName, String currency);

}
