package be.willekens.multi.module.template.domain.repository;

import be.willekens.multi.module.template.domain.models.parking_lot.PostalCode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
