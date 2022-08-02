package com.diligroup.simplebanksystem.service;

import com.diligroup.simplebanksystem.model.Transaction;

public interface TransactionService {

	Transaction deposit(Transaction transaction);

	Transaction withdraw(Transaction transaction);

}
