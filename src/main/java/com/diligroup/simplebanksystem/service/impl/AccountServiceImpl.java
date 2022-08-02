package com.diligroup.simplebanksystem.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.diligroup.simplebanksystem.exception.BankException;
import com.diligroup.simplebanksystem.model.Account;
import com.diligroup.simplebanksystem.model.Transaction;
import com.diligroup.simplebanksystem.repository.AccountRepository;
import com.diligroup.simplebanksystem.service.AccountService;
import com.diligroup.simplebanksystem.service.TransactionService;
import com.diligroup.simplebanksystem.utils.AccountUtil;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionService transactionService;

	@Override
	@Transactional
	public Account createAccount(String userName, String currency) {

		Account account = new Account(userName, AccountUtil.generateRandomAccountNumber(), currency, 0);

		return accountRepository.save(account);
	}

	@Override
	@Transactional
	public Account deposit(String accountNo, double amount) {

		Optional<Account> optionalAccount = accountRepository.findByAccountNo(accountNo);

		if(optionalAccount.isPresent()) {

			Account account = optionalAccount.get();

			Transaction transaction = transactionService.deposit( new Transaction(account, amount));

			account.setBalance(transaction.getBalance());

			accountRepository.save(account);

			return account;

		} else {
			throw new BankException("Some internal error happened, Deposit cannot be process now", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	@Transactional
	public Account withdraw(String accountNo, double amount) {

		Optional<Account> optionalAccount = accountRepository.findByAccountNo(accountNo);

		if(optionalAccount.isPresent()) {

			Account account = optionalAccount.get();

			Transaction transaction = transactionService.withdraw(new Transaction(account, amount));

			account.setBalance(transaction.getBalance());

			accountRepository.save(account);

			return account;

		} else {
			throw new BankException("Some internal error happened, Withdraw cannot be process now", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
