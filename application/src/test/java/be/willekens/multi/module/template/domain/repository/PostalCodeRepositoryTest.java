package be.willekens.multi.module.template.domain.repository;

import be.willekens.multi.module.template.domain.models.address.PostalCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PostalCodeRepositoryTest {

    @Autowired
    private PostalCodeRepository postalCodeRepository;

    @Test
    void findByPostalCode_ifPostalCodeInDatabase_thenReturnValidPostalCode() {
        PostalCode postalCode = postalCodeRepository.findByPostalCode("1234");
        assertThat(postalCode.getLabel()).isEqualTo("Buenos Aires");
    }

    @Test
    void findByPostalCode_ifNonExistentPostalCode_thenReturnNull() {
        PostalCode postalCode = postalCodeRepository.findByPostalCode("12345");
        assertThat(postalCode).isNull();
    }

}
