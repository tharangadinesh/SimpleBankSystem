package com.diligroup.simplebanksystem.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.diligroup.simplebanksystem.model.Account;
import com.diligroup.simplebanksystem.repository.AccountRepository;
import com.diligroup.simplebanksystem.service.impl.AccountServiceImpl;

@ExtendWith(SpringExtension.class)
class AccountServiceImplTest {

	@Mock
	private AccountRepository accountRepository;

	private AccountService accountService;

	@BeforeEach
	public void setUp() {
		this.accountService = new AccountServiceImpl();
	}

	@Test
	void createAccount_success() {

		Account account = new Account();
		account.setAcccountNo("Ranjith");
		account.setCurrency("EURO");
		account.setBalance(0);

		Account detailDto = accountService.createAccount("Dave", "EURO");

		verify(accountRepository, times(1)).save(Mockito.isA(Account.class));

	}
}
