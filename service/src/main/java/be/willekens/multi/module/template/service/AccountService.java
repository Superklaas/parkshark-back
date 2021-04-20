package be.willekens.multi.module.template.service;

import be.willekens.multi.module.template.domain.models.users.Account;
import be.willekens.multi.module.template.domain.repository.AccountRepository;
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
}
