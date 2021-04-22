package be.willekens.multi.module.template.domain.repository;

import be.willekens.multi.module.template.domain.models.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findAccountByEmailAndEncryptedPassword(String email, String password);
}
