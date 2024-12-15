package com.superklaas.domain.repository;

import com.superklaas.domain.models.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findAccountByEmailAndEncryptedPassword(String email, String password);

    Account findAccountByEmail(String email);

}
