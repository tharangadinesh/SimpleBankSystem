package com.diligroup.simplebanksystem.service.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.diligroup.simplebanksystem.constant.TransactionType;
import com.diligroup.simplebanksystem.exception.BankException;
import com.diligroup.simplebanksystem.model.Account;
import com.diligroup.simplebanksystem.model.Transaction;
import com.diligroup.simplebanksystem.repository.TransactionRepository;
import com.diligroup.simplebanksystem.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	@Transactional
	public Transaction deposit(Transaction transaction) {

		transaction.setTransactionType(TransactionType.DEPOSIT);
		transaction.setDescription("Credited on " + new Date());
		transaction.setBalance( transaction.getAccount().getBalance() + transaction.getAmount());

		return transactionRepository.save(transaction);
	}

	@Override
	@Transactional
	public Transaction withdraw(Transaction transaction) {

		checkDebitAccountBalance(transaction.getAccount(), transaction.getAmount());

		transaction.setTransactionType(TransactionType.WITHDRAW);
		transaction.setDescription("debited on " + new Date());
		transaction.setBalance( transaction.getAccount().getBalance() - transaction.getAmount());

		return transactionRepository.save(transaction);
	}

	private void checkDebitAccountBalance(Account account, double amount) {
		if(amount > account.getBalance()) {
			throw new BankException("Debit account not have the enough fund to proceed transaction", HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
