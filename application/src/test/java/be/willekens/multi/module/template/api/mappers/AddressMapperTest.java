package be.willekens.multi.module.template.api.mappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class AddressMapperTest {

    @Autowired
    private AddressMapper addressMapper;


    @Test
    void ifPostalCodeAlreadyExistsInDB_DBOneIsUsed(){
//        addressMapper.address_to_receiveAddress(new Address("blubl","snurp",new PostalCode("njue","shmeu")));
    }

    @Test
    void ifPostalCodeDoesNotAlreadyExist_ANewOneIsMadeAndAddedToTheDB(){

    }
}
