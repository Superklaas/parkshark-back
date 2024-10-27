package com.superklaas.service;

import com.superklaas.domain.models.account.Account;
import com.superklaas.domain.repository.AccountRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account findAccountByEmailAndPassword(String email, String password) {
        return accountRepository.findAccountByEmailAndEncryptedPassword(email, password);
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }
}
