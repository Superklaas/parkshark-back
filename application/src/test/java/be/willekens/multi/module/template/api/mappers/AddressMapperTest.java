package be.willekens.multi.module.template.api.mappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class AddressMapperTest {

    private AddressMapper addressMapper;

    @Autowired
    public AddressMapperTest(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    @Test
    void ifPostalCodeAlreadyExistsInDB_DBOneIsUsed(){

    }

    @Test
    void ifPostalCodeDoesNotAlreadyExist_ANewOneIsMadeAndAddedToTheDB(){

    }
}