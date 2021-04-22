package be.willekens.multi.module.template.domain.repository;

import be.willekens.multi.module.template.domain.models.users.Account;
import be.willekens.multi.module.template.domain.models.users.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void findAccountByEmailAndEncryptedPassword_ifEmailAndPasswordInDatabase_thenReturnValidAccount() {
        Account account = accountRepository.findAccountByEmailAndEncryptedPassword("ihsan@parkshark.be", "admin");
        assertThat(account.getRole()).isEqualTo(Role.MANAGER);
        assertThat(account.getId()).isEqualTo(1);
    }

    @Test
    void findAccountByEmailAndEncryptedPassword_ifNonExistentEmail_thenReturnNull() {
        Account account = accountRepository.findAccountByEmailAndEncryptedPassword("ihsan1@parkshark.be", "admin");
        assertThat(account).isNull();
    }

    @Test
    void findAccountByEmailAndEncryptedPassword_ifPasswordIncorrect_thenReturnNull() {
        Account account = accountRepository.findAccountByEmailAndEncryptedPassword("ihsan@parkshark.be", "admin1");
        assertThat(account).isNull();
    }

}
